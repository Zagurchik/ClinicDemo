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
    public String findAll(Model model) {
        List<AppointmentSheet> appointmentSheets = appointmentSheetRepository.findAll();
        model.addAttribute("appointmentSheets", appointmentSheets);
        return "appointmentSheets";
    }

    @GetMapping("/addAppointment")
    public String add(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
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
    @GetMapping("/updateAppointmentSheet")
    public String update (@RequestParam int id, Model model) {
        AppointmentSheet appointmentSheet = appointmentSheetRepository.findById(id).get();
        model.addAttribute("appointmentSheet",appointmentSheet);
        return "updateAppointmentSheet";
    }

    @PostMapping("/updateAppointmentSheet")
    public String update (@ModelAttribute AppointmentSheet appointmentSheet) {
        appointmentSheetRepository.save(appointmentSheet);
        return "redirect:appointmentSheets";
    }
}
