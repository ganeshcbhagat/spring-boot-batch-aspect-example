package com.opportunity.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MethodExecutionAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("com.opportunity.spring.pointcut.CommonJoinPointConfiguration.methodExecution()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        joinPoint.proceed();
        stopWatch.stop();

        logger.info("Time taken by {} is {} millis", joinPoint, stopWatch.getTotalTimeMillis());

    }
    
}
