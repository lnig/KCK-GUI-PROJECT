package com.example.kckgui;

import com.example.kckgui.Model.Type.priorityType;
import com.example.kckgui.Model.Type.statusType;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import com.example.kckgui.Model.Class.Task;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.Random;

public class taskViewController {

    @FXML
    private Circle avatar;

    @FXML
    private Label taskDescritpion;

    @FXML
    private Label taskMember;

    @FXML
    private Label taskPriority;

    @FXML
    private Label taskTitle;
    private static int taskToDeleteId;
    private int i = 0;

    public void setData(Task task){
        taskTitle.setText(task.getTitle());
        taskDescritpion.setText(task.getDescription());
        taskPriority.setText(task.getPriority().toString());
        taskMember.setText(task.getWhoWillDo().getName());

        Image img1 = new Image("C:\\Users\\dmier\\Desktop\\KckGui\\KckGui\\src\\main\\resources\\images\\icons8-avatar-96.png");
        Image img2 = new Image("C:\\Users\\dmier\\Desktop\\KckGui\\KckGui\\src\\main\\resources\\images\\icons8-avatar-48.png");

        Random random = new Random();
        i = random.nextInt(2) + 1;

        if (i % 2 == 1){
            avatar.setFill(new ImagePattern(img1));
        }else{
            avatar.setFill(new ImagePattern(img2));
        }

        if (task.getStatus() == statusType.WYKONANE) {
            taskTitle.getStylesheets().addAll(getClass().getResource(
                    "strikethrough.css"
            ).toExternalForm());
        }

        switch (task.getPriority()){
            case PILNE -> {
                taskPriority.setStyle("-fx-background-color: #FF0000");
            }
            case WYSOKI -> {
                taskPriority.setStyle("-fx-background-color: #FFA500");
            }
            case SREDNI -> {
                taskPriority.setStyle("-fx-background-color: #ffd100 ");
            }case NISKI -> {
                taskPriority.setStyle("-fx-background-color: #008000");
            }
        }


    }

    @FXML
    public void select(MouseEvent event) {
        String source1 = event.getSource().toString();
        String s = source1.substring(12, source1.length() - 1);
        taskToDeleteId = Integer.parseInt(s);
        System.out.println(source1);
        System.out.println(s);
    }

    public static int taskID(){
        return taskToDeleteId;
    }
}
