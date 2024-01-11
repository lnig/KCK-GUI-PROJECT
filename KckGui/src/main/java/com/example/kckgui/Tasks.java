package com.example.kckgui;

import com.example.kckgui.Controller.taskController;
import com.example.kckgui.Model.Class.Task;
import com.example.kckgui.Model.Class.familyMember;
import com.example.kckgui.Model.Type.priorityType;
import com.example.kckgui.Model.Type.statusType;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import static com.example.kckgui.Controller.familyMemberController.getFamilyMembers;
import static com.example.kckgui.Controller.taskController.getTasks;


public class Tasks implements Initializable {

    @FXML
    private ImageView exit;
    @FXML
    private ImageView minimize;
    @FXML
    private ImageView exitTabDoneTask;
    @FXML
    private ImageView minimizeTabDoneTask;
    @FXML
    private GridPane taskToDoController;
    @FXML
    private GridPane taskInProgressController;
    @FXML
    private GridPane taskDoneController;
    @FXML
    private DialogPane dialogAdd;
    @FXML
    private DialogPane dialogEdit;
    @FXML
    private ComboBox<priorityType> priorityChoose;
    @FXML
    private ComboBox<familyMember> memberChoose;
    @FXML
    private TextArea taskDescription;
    @FXML
    private TextField taskTitle;
    @FXML
    private ComboBox<priorityType> priorityChooseEdit;
    @FXML
    private ComboBox<familyMember> memberChooseEdit;
    @FXML
    private TextArea taskDescriptionEdit;
    @FXML
    private TextField taskTitleEdit;
    @FXML
    private Label errorMsg;
    @FXML
    private TabPane tabPane;
    private  int column = 0;
    private int row = 1;
    int columnD = 0;
    int rowD = 1;
    private int taskType = 0;
    private int id = 0;
    private ArrayList<Task> tasks1 = getTasks();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
        });

        exitTabDoneTask.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimizeTabDoneTask.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
        });

        priorityChoose.getItems().addAll(priorityType.values());
        priorityChoose.setValue(priorityType.SREDNI);
        memberChoose.getItems().addAll(getFamilyMembers());
        priorityChooseEdit.getItems().addAll(priorityType.values());
        priorityChooseEdit.setValue(priorityType.SREDNI);
        memberChooseEdit.getItems().addAll(getFamilyMembers());

        try {
            for (Task t: tasks1) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SingleTaskView.fxml"));
                VBox taskBox = fxmlLoader.load();
                taskBox.setId("task" + ++id);
                taskViewController taskViewController = fxmlLoader.getController();
                taskViewController.setData(t);

                switch (t.getStatus()){
                    case DO_ZROBIENIA -> {
                        if (column == 1){
                            column = 0;
                            ++row;
                        }

                        taskToDoController.add(taskBox, column++, row);
                        GridPane.setMargin(taskBox, new Insets(5, 5, 5, 5));
                    }
                    case W_TOKU -> {
                        if (column == 1){
                            column = 0;
                            ++row;
                        }

                        taskInProgressController.add(taskBox, column++, row);
                        GridPane.setMargin(taskBox, new Insets(5, 5, 5, 5));
                    }
                    case WYKONANE -> {
                        if (columnD == 2) {
                            columnD = 0;
                            ++rowD;
                        }
                        taskDoneController.add(taskBox, columnD++, rowD);
                        GridPane.setMargin(taskBox, new Insets(5, 5, 5, 5));
                        taskDoneController.setHgap(35);
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createToDoTask(ActionEvent actionEvent) {

        dialogAdd.setVisible(true);
        tabPane.setEffect(new GaussianBlur(10));
        taskType = 1;
    }
    public void createInProgressTask(ActionEvent actionEvent) {

        dialogAdd.setVisible(true);
        tabPane.setEffect(new GaussianBlur(10));
        taskType = 2;

    }
    public void createDoneTask(ActionEvent actionEvent) {
        dialogAdd.setVisible(true);
        tabPane.setEffect(new GaussianBlur(10));
        taskType = 3;
    }

    public void addTask(ActionEvent actionEvent) {

        String title = "", description= "";
        priorityType priorityType;
        familyMember familyMember;
        Task task = null;

        try {
            title = taskTitle.getText();
            description = taskDescription.getText();
            priorityType = priorityChoose.getValue();
            familyMember = memberChoose.getValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        if (title.isEmpty() || description.isEmpty()) {
            errorMsg.setText("Fill in all fields");
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("SingleTaskView.fxml"));

        try {
            VBox taskBox = fxmlLoader.load();
            taskBox.setId("task" + ++id);
            taskViewController taskViewController = fxmlLoader.getController();

            if (column == 1){
                column = 0;
                ++row;
            }

            if (columnD == 2){
                columnD = 0;
                ++rowD;
            }
            switch (taskType){
                case 1 ->{
                    task = new Task(id, title, description, priorityType, statusType.DO_ZROBIENIA, familyMember);
                    taskToDoController.add(taskBox, column++, row);
                }
                case 2 ->{
                    task = new Task(id, title, description, priorityType, statusType.W_TOKU, familyMember);
                    taskInProgressController.add(taskBox, column++, row);
                }
                case 3->{
                    task = new Task(id, title, description, priorityType, statusType.WYKONANE, familyMember);
                    taskDoneController.add(taskBox, columnD++, rowD);
                }
            }
            taskViewController.setData(task);
            GridPane.setMargin(taskBox, new Insets(5, 5, 5, 5));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        taskController.addTask(task);

        dialogAdd.setVisible(false);
        tabPane.setEffect(new GaussianBlur(0));
        clearFields();

    }
    public void cancelAddingTask(ActionEvent actionEvent) {

        dialogAdd.setVisible(false);
        tabPane.setEffect(new GaussianBlur(0));
        clearFields();

    }
    public void clearFields(){
        taskTitle.clear();
        taskDescription.clear();
        priorityChoose.setValue(priorityType.SREDNI);
        memberChoose.setValue(null);
    }
    public void removeTask(ActionEvent actionEvent) {

        tasks1.remove(taskViewController.taskID() - 1);
        System.out.println(tasks1.size());
        taskToDoController.getChildren().clear();
        taskInProgressController.getChildren().clear();
        id = 0;

        refresh();

    }
    public void refresh(){
        columnD = 0;
        taskToDoController.getChildren().clear();
        taskInProgressController.getChildren().clear();
        taskDoneController.getChildren().clear();
        id = 0;
        try {
            for (Task t: tasks1) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SingleTaskView.fxml"));
                VBox taskBox = fxmlLoader.load();
                taskBox.setId("task" + ++id);
                taskViewController taskViewController = fxmlLoader.getController();
                taskViewController.setData(t);

                switch (t.getStatus()){
                    case DO_ZROBIENIA -> {
                        if (column == 1){
                            column = 0;
                            ++row;
                        }

                        taskToDoController.add(taskBox, column++, row);
                        GridPane.setMargin(taskBox, new Insets(5, 5, 5, 5));
                    }
                    case W_TOKU -> {
                        if (column == 1){
                            column = 0;
                            ++row;
                        }

                        taskInProgressController.add(taskBox, column++, row);
                        GridPane.setMargin(taskBox, new Insets(5, 5, 5, 5));
                    }
                    case WYKONANE -> {
                        if (columnD == 2) {
                            columnD = 0;
                            ++rowD;
                        }
                        taskDoneController.add(taskBox, columnD++, rowD);
                        GridPane.setMargin(taskBox, new Insets(5, 5, 5, 5));
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void editTask(ActionEvent actionEvent) {

        dialogEdit.setVisible(true);
        tabPane.setEffect(new GaussianBlur(10));

        Task task = tasks1.get(taskViewController.taskID() - 1);

        taskTitleEdit.setText(task.getTitle());
        taskDescriptionEdit.setText(task.getDescription());
        memberChooseEdit.setValue(task.getWhoWillDo());
        priorityChooseEdit.setValue(task.getPriority());

    }
    public void editTaskConfirm(ActionEvent actionEvent) {

        Task task = tasks1.get(taskViewController.taskID() - 1);
        task.setTitle(taskTitleEdit.getText());
        task.setDescription(taskDescriptionEdit.getText());
        task.setWhoWillDo(memberChooseEdit.getValue());
        task.setPriority(priorityChooseEdit.getValue());



       refresh();

        dialogEdit.setVisible(false);
        tabPane.setEffect(new GaussianBlur(0));

    }
    public void cancelEditingTask(ActionEvent actionEvent) {

        dialogEdit.setVisible(false);
        tabPane.setEffect(new GaussianBlur(0));

    }

    public void changeStatus(ActionEvent actionEvent) {

        Task task = tasks1.get(taskViewController.taskID() - 1);
        System.out.println(task.getTitle() + " " + task.getDescription() + task.getStatus());
        if (task.getStatus() == statusType.DO_ZROBIENIA){
            task.setStatus(statusType.W_TOKU);
        }else if (task.getStatus() == statusType.W_TOKU){
            task.setStatus(statusType.WYKONANE);
        }else {
            errorMsg.setText("Nie mozesz tego zrobic");
        }

        refresh();

    }
}