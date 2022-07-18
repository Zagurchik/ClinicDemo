package com.example.ClinicDemo.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String diagnose;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<AppointmentSheet> appointmentSheets;

    public List<AppointmentSheet> getAppointmentSheets() {
        return appointmentSheets;
    }

    public void setAppointmentSheets(List<AppointmentSheet> appointmentSheets) {
        this.appointmentSheets = appointmentSheets;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date birthdate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Patient() {
    }

    public Patient(int id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Patient(int id) {
        this.id = id;
    }

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Patient(int id, String name, String surname, String patronymic, List<AppointmentSheet> appointmentSheets) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.appointmentSheets = appointmentSheets;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " +
                patronymic + " " + birthdate;
    }
}
