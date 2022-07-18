package com.example.ClinicDemo.controller;

import com.example.ClinicDemo.Model.Patient;
import com.example.ClinicDemo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientRepository repository;

    @GetMapping("/patients")
    public String findAll(Model model){
        List<Patient> patients = repository.findAll();
        model.addAttribute("patients",patients);
        return "patients";
    }

    @GetMapping("/addPatients")
    public String add (){
        return "addPatients";
    }

    @PostMapping("/addPatients")
    public String add (@ModelAttribute Patient patient){
        repository.save(patient);
        return "redirect:patients";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam int id) {
        repository.deleteById(id);
        return "redirect:patients";
    }


    @GetMapping("/updatePatients")
    public String update (@RequestParam int id, Model model) {
        Patient patient = repository.findById(id).get();
        model.addAttribute("patient",patient);
        return "updatePatients";
    }

    @PostMapping("/update")
    public String update (@ModelAttribute Patient patient) {
        repository.save(patient);
        return "redirect:patients";
    }
}

