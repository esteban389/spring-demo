package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestLogger {

    Logger log = LoggerFactory.getLogger(RestLogger.class);

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Calling method: {}", joinPoint.getSignature().toShortString());
        log.info("Arguments: {}", joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.controller.*.*(..))", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        log.info("Method {} executed successfully. Returned: {}", joinPoint.getSignature().toShortString(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.demo.controller.*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        log.error("Error in method {}: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }
}
