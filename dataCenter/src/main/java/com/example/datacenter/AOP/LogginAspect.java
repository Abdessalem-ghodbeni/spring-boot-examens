package com.example.datacenter.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogginAspect {

//    @Before(value = "execution (* tn.esprit.tp1_ghodbani_abdessalem_4twin_7.services..*(..))")
//    public void logMethodeEntry(JoinPoint joinPoint){
//        String name=joinPoint.getSignature().getName();
//        log.info("IN Methode "+name);
//        System.out.println("IN Methode "+name);
//    }
//
//    @After(value = "execution (* tn.esprit.tp1_ghodbani_abdessalem_4twin_7.services..*(..))")
//    public void logMethodExit(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        log.info("« Out of method " + name + " : ");
//        System.out.println("« Out of method " + name + " : ");
//    }


    @Around(value = "execution (* com.example.datacenter.Services..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        log.info(joinPoint.getSignature() + "yup  executed in " + duration + "ms");

        return proceed;
    }
}
