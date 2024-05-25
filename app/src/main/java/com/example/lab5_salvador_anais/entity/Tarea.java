package com.example.lab5_salvador_anais.entity;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Tarea implements Serializable{
    private String titulo;
    private long reminderTime;
    private String descripcion;
    private boolean notified;

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }

    public Tarea(String titulo, String descripcion, long reminderTime) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.reminderTime = reminderTime;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(long reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isReadyForNotification(long currentTime) {
        return reminderTime <= currentTime && currentTime <= reminderTime + TimeUnit.MINUTES.toMillis(15);
    }

}


