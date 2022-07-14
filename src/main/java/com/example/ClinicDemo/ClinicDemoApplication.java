package com.example.ClinicDemo;

import com.example.ClinicDemo.repository.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClinicDemoApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(ClinicDemoApplication.class, args);
		PatientRepository repository = context.getBean(PatientRepository.class);
	}

}
