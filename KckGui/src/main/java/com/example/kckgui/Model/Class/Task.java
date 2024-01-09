package com.example.kckgui.Model.Class;

import com.example.kckgui.Model.Type.priorityType;
import com.example.kckgui.Model.Type.statusType;

public class Task {

    private int id;
    private String title;
    private String description;
    private priorityType priority;
    private statusType status;
    private familyMember whoWillDo;

    public Task(int id, String title, String description, priorityType priority, statusType status, familyMember whoWillDo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.whoWillDo = whoWillDo;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public priorityType getPriority() {
        return priority;
    }
    public statusType getStatus() {
        return status;
    }
    public familyMember getWhoWillDo() {
        return whoWillDo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPriority(priorityType priority) {
        this.priority = priority;
    }
    public void setStatus(statusType status) {
        this.status = status;
    }
    public void setWhoWillDo(familyMember whoWillDo) {
        this.whoWillDo = whoWillDo;
    }
}
