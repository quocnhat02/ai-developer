package com.beginner.springbootmaster;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MonitoringAspect {
    @Before("execution(* com.beginner.springbootmaster.*.*(..))")
    public void logServiceInvocation(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}
