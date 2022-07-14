package com.example.ClinicDemo.repository;

import com.example.ClinicDemo.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
