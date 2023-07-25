package com.diamorph.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private final Logger logger = LoggerFactory.getLogger(Logger.class);

//    @Around("execution(* com.diamorph.learnspringaop.aopexample.*.*.*(..))")
    @Around("com.diamorph.learnspringaop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start a timer
        long startTime = System.currentTimeMillis();

        // Execute the method
        Object returnValue = proceedingJoinPoint.proceed();

        // stop the timer
        long stopTimer = System.currentTimeMillis();

        long executionDuration = stopTimer - startTime;

        logger.info("Around Aspect - {} Method executed in {}", proceedingJoinPoint, executionDuration);

        return returnValue;
    }
}
