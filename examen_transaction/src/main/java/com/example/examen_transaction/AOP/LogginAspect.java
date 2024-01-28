package com.example.examen_transaction.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogginAspect {
    @Around(value = "execution (* com.example.examen_transaction.Services..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        log.info(joinPoint.getSignature() + "yup  executed in " + duration + "ms");

        return proceed;
    }

}


