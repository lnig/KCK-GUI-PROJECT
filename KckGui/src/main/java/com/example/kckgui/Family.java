package com.example.kckgui;

import com.example.kckgui.Controller.familyMemberController;
import com.example.kckgui.Model.Class.familyMember;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class Family implements Initializable {

    @FXML
    private ListView<familyMember> listView;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView minimize;
    @FXML
    private MFXTextField textFieldNameFM;
    @FXML
    private AnchorPane content;
    private ArrayList<familyMember> members = familyMemberController.getFamilyMembers();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
        });

        listView.getItems().addAll(members);

        listView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() >= 0) {
                familyMember selectedMember = listView.getItems().get(newValue.intValue());
                textFieldNameFM.setText(selectedMember.getName());
            }
        });

        content.setOnMouseClicked(mouseEvent -> {
            listView.getSelectionModel().clearSelection();
            clearFields();
            content.requestFocus();
        });
    }

    @FXML
    public void editFM(ActionEvent actionEvent) {
        familyMember selectedMember = listView.getSelectionModel().getSelectedItem();
        if (selectedMember != null) {
            String newName = textFieldNameFM.getText();
            selectedMember.setName(newName);
            refreshListView();
        } else {
            showAlert("No family member selected for editing.");
        }
    }

    @FXML
    public void deleteFM(ActionEvent actionEvent) {
        int id = listView.getSelectionModel().getSelectedIndex();
        System.out.println(id);
        if (id != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Confirm Deletion");
            alert.setContentText("Are you sure you want to delete selected family members?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                listView.getItems().remove(id);
                members.remove(id);
            }
        } else {
            showAlert("No family members selected for deletion.");
        }
    }

    @FXML
    public void addFM(ActionEvent actionEvent) {
        String fMName = textFieldNameFM.getText();
        if (fMName.isEmpty() || fMName.isBlank()){
           showAlert("Wypelnij Pola");
        }else{
            familyMember fM = new familyMember(fMName);
            familyMemberController.addFamilyMember(fM);
            listView.getItems().add(fM);
        }
    }

    public void clearFields(){
        textFieldNameFM.clear();
        textFieldNameFM.requestFocus();
        content.requestFocus();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void refreshListView() {
        listView.requestLayout();
    }

}
