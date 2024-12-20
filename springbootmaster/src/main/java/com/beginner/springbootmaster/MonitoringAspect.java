package com.beginner.springbootmaster;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitoringAspect {
    @Before("execution(* com.beginner.springbootmaster.*.*(..))")
    public void logServiceInvocation(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}
