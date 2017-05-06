package com.tneciv.poseidon.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Tneciv on 2017/5/6.
 */
@Aspect
@Component
@Slf4j
public class PageAspect {

    @Pointcut("execution(public * com.tneciv.poseidon.controller.*.*(..))")
    public void controllerPoint() {
    }

    @Before("controllerPoint()")
    public void ctrlBefore(JoinPoint point) {
        Object[] args = point.getArgs();
        String className = point.getSignature().getDeclaringTypeName();
        String methodName = point.getSignature().getName();
        log.debug("{} in {} has been called, para is {}", methodName, className, args.toString());
    }

}
