package com.anupamsingh.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TaskExecutionAspect {

  @Pointcut("@annotation(com.anupamsingh.springaop.annotation.TaskExecution)")
  public void taskExecutionMethods() {}

  @Around("taskExecutionMethods()")
  public Object aroundTaskExecutionMethods(ProceedingJoinPoint joinPoint) throws Throwable {
    Long start = System.currentTimeMillis();
    Object result = joinPoint.proceed();
    System.out.println("Execution time for method " + joinPoint.getSignature().getName() + " is " + (System.currentTimeMillis() - start) + " ms");
    return result;
  }

}
