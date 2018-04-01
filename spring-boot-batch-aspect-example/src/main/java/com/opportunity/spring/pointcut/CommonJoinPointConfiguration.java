package com.opportunity.spring.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class CommonJoinPointConfiguration {

    @Pointcut("@annotation(com.opportunity.spring.pointcut.TrackTime)")
    public void methodExecution() {}
    
}
