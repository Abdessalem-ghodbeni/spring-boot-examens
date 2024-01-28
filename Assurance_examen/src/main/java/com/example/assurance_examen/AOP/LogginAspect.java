package com.example.assurance_examen.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LogginAspect {

  @AfterReturning(value = "execution (* com.example.assurance_examen.Services..*(..))")
  public void logMethodExit(JoinPoint joinPoint) {
      if(joinPoint.getSignature().getName().startsWith("get")){
          log.info(joinPoint.getSignature().getName() +"Bon courage !");
      }
  }




}
