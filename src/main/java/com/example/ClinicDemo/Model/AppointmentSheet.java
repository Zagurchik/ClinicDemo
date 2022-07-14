package com.example.ClinicDemo.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class AppointmentSheet {
    private int date;
    private String appointment;
    boolean isDo;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public boolean isDo() {
        return isDo;
    }

    public void setDo(boolean aDo) {
        isDo = aDo;
    }
}
