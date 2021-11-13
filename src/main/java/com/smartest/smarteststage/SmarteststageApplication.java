package com.smartest.smarteststage;

import com.smartest.smarteststage.entity.Employee;
import com.smartest.smarteststage.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

@SpringBootApplication
public class SmarteststageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmarteststageApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args -> {
        });
    }

    private void insertEmployee(EmployeeRepository repository) {

    }

}
