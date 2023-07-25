package com.diamorph.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.diamorph.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.diamorph.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.diamorph.learnspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("bean(*Service*)")
    public void dataService1PackageConfigUsingBean() {}

    @Pointcut("@annotation(com.diamorph.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
