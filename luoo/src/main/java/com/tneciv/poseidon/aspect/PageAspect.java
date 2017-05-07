package com.tneciv.poseidon.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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

    @Pointcut("execution(public * com.tneciv.poseidon.controller.*.*(Integer,Integer))&& args(pageNum,pagsSize)")
    public void pageParaPoint(Integer pageNum, Integer pagsSize) {
    }

    @Before("controllerPoint()")
    public void ctrlBefore(JoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        String className = point.getSignature().getDeclaringTypeName();
        String methodName = point.getSignature().getName();
        log.debug("{} in {} has been called, para is {}", methodName, className, args.toString());
    }

    @Around(value = "pageParaPoint(pageNum , pagsSize)", argNames = "pageNum,pagsSize")
    public Object handlePagePara(ProceedingJoinPoint joinpoint, Integer pageNum, Integer pagsSize) throws Throwable {

        Object[] args = joinpoint.getArgs(); //7
        if (args[0] == null) {

        } else {

        }
        return joinpoint.proceed(args);
    }
    
}
