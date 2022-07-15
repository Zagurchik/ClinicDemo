package com.example.ClinicDemo.controller;

import com.example.ClinicDemo.Model.AppointmentSheet;
import com.example.ClinicDemo.Model.Patient;
import com.example.ClinicDemo.repository.AppointmentSheetRepository;
import com.example.ClinicDemo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentSheetController {
    @Autowired
    AppointmentSheetRepository appointmentSheetRepository;
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/appointmentSheets")
    public String foundAll(Model model) {
        List<AppointmentSheet> appointmentSheets = appointmentSheetRepository.findAll();
        model.addAttribute("appointmentSheets", appointmentSheets);
        return "appointmentSheets";
    }

    @GetMapping("/addAppointment")
    public String add(@RequestParam int id, Model model) {

        Patient patient = patientRepository.findById(id).get();
        model.addAttribute("patient", patient);
        return "addAppointment";
    }

    @PostMapping("/addAppointment")
    public String add(@ModelAttribute AppointmentSheet appointmentSheet) {
        appointmentSheetRepository.save(appointmentSheet);
        return "redirect:appointmentSheets";
    }

    @GetMapping("/deleteAppointment")
    public String delete(@RequestParam int id) {
        appointmentSheetRepository.deleteById(id);
        return "redirect:appointmentSheets";
    }

}
