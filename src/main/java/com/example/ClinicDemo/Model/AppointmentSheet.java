package com.example.ClinicDemo.Model;

import javax.persistence.*;


@Entity
public class AppointmentSheet {
    private String diagnostics;
    private String tablets;
    private String injection;

    @ManyToOne
    private Patient patient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public String getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(String diagnostics) {
        this.diagnostics = diagnostics;
    }

    public String getTablets() {
        return tablets;
    }

    public void setTablets(String tablets) {
        this.tablets = tablets;
    }

    public String getInjection() {
        return injection;
    }

    public void setInjection(String injection) {
        this.injection = injection;
    }

    @Override
    public String toString() {
        return "AppointmentSheet{" +
                "diagnostics='" + diagnostics + '\'' +
                ", tablets='" + tablets + '\'' +
                ", injection='" + injection + '\'' +
                ", patient=" + patient +
                ", id=" + id +
                '}';
    }
}
