package com.example.lab5_salvador_anais.entity;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Tarea implements Serializable{
    private String title;
    private String description;
    private long reminderTime;
    private boolean notified;

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }

    public Tarea(String title, String description, long reminderTime) {
        this.title = title;
        this.description = description;
        this.reminderTime = reminderTime;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(long reminderTime) {
        this.reminderTime = reminderTime;
    }

    public boolean isReadyForNotification(long currentTime) {
        return reminderTime <= currentTime && currentTime <= reminderTime + TimeUnit.MINUTES.toMillis(15);
    }
}


