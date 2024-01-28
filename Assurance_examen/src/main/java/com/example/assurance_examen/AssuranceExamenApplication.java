package com.example.assurance_examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class AssuranceExamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssuranceExamenApplication.class, args);
    }

}
