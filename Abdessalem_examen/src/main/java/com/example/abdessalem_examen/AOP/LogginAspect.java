package com.example.abdessalem_examen.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogginAspect {


    @AfterReturning(value = "execution (* com.example.abdessalem_examen.Services.IExamenServiceImp.addVehicleReservationAndAffectToWashingservice(..))")
    public void afterAddVehicleReservationAndAffectToWashingservice() {

        log.info(" Wating Fora worker ");

    }

}
