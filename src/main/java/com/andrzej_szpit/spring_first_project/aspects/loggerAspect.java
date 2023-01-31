package com.andrzej_szpit.spring_first_project.aspects;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class loggerAspect {
    @Before("execution(* com.andrzej_szpit.spring_first_project.controllers.*.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println(LocalDateTime.now() + " Method " + joinPoint + " started");
    }
    @AfterReturning("execution(* com.andrzej_szpit.spring_first_project.controllers.*.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println(LocalDateTime.now() + " Method " + joinPoint + " stopped");
    }

    
}
