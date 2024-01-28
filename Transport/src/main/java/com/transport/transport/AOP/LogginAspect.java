package com.transport.transport.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogginAspect {
        @AfterReturning(value = "execution (* com.transport.transport.Services..*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = null;
        if (joinPoint.getSignature().getName().startsWith("ajouter")) {
            name = "Méthode d'ajout ";
        } else if (joinPoint.getSignature().getName().startsWith("affecter")) {
            name = "Méthode d'affectation ";
        }
        log.info("« Out of method " + name + " : ");
        System.out.println("« Out of method " + name + " : ");
    }


}
