package com.example.ClinicDemo.repository;

import com.example.ClinicDemo.Model.AppointmentSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentSheetRepository extends JpaRepository<AppointmentSheet,Integer> {
}
