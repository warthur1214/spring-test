package com.warthur.spring.hibernate.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * aop
 * Created by warthur on 17/7/16.
 */
@Aspect
@Component
public class LogAopInterceptor {

    @Pointcut("execution(public * com.warthur.spring.aop.service..*.*(..))")
    public void logMethod() {}

    @Before("logMethod()")
    public void before() {
        System.out.println("log before.....");
    }

    @After("logMethod()")
    public void after() {
        System.out.println("log after.....");
    }

    /**
     * 异常捕捉切面 无异常抛出则不执行
     */
    @AfterThrowing("logMethod()")
    public void afterThrowing() {
        System.out.println("log afterThrowing.....");
    }

    /**
     * 方法return后执行
     */
    @AfterReturning("logMethod()")
    public void AfterReturning() {
        System.out.println("log AfterReturning.....");
    }

    /**
     * 方法前后执行切面
     */
    @Around("logMethod()")
    public void Around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("log Around start.....");

        point.proceed();

        System.out.println("log Around end.....");
    }
}
