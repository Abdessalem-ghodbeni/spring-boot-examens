package com.example.examen_2022.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogginAspects {
    @After("execution(* com.example.examen_2022.Services..*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        if(name.startsWith("get")){
            log.info("Bon courage ! : " + name );
        }

    }
}
