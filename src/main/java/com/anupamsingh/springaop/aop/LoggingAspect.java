package com.anupamsingh.springaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

  @Pointcut("execution(* com.anupamsingh.springaop.controller.*.*(..))")
  public void controllerMethods() {}

  @Before("controllerMethods()")
  public void logBeforeControllerMethods(JoinPoint joinPoint) {
    log.info("Before the method {} executes....", joinPoint.getSignature().getName());
  }

  @After("controllerMethods()")
  public void logAfterControllerMethods(JoinPoint joinPoint) {
    log.info("After the method {} is completed...", joinPoint.getSignature().getName());
  }
}
