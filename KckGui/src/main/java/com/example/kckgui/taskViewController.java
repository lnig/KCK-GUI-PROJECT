package com.example.kckgui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import com.example.kckgui.Model.Class.Task;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

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

    public void setData(Task task){
        taskTitle.setText(task.getTitle());
        taskDescritpion.setText(task.getDescription());
        taskPriority.setText(task.getPriority().toString());
        taskMember.setText(task.getWhoWillDo().toString());
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
