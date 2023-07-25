package com.diamorph.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(Logger.class);

    @Before("com.diamorph.learnspringaop.aopexample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect {} - is called with args: {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.diamorph.learnspringaop.aopexample.aspects.CommonPointcutConfig.dataService1PackageConfigUsingBean()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect {} has executed", joinPoint);
    }

    @AfterThrowing(
        pointcut = "com.diamorph.learnspringaop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()",
        throwing = "exception"
    )
    public void logMethodCallAfterThrowingExecution(JoinPoint joinPoint, Exception exception) {
        logger.info("After Throwing Aspect - {} has thrown an exception {}", joinPoint, exception);
    }

    @AfterReturning(
        pointcut = "com.diamorph.learnspringaop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()",
        returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("After Returning Aspect - {} has returned {}", joinPoint, resultValue);
    }
}
