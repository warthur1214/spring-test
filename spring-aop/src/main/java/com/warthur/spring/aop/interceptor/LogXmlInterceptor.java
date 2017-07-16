package com.warthur.spring.aop.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by warthur on 17/7/16.
 */
public class LogXmlInterceptor {

    public void before() {
        System.out.println("log before.....");
    }

    public void after() {
        System.out.println("log after.....");
    }

    public void afterThrowing() {
        System.out.println("log afterThrowing.....");
    }

    public void afterReturning() {
        System.out.println("log AfterReturning.....");
    }

    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("log Around start.....");

        point.proceed();

        System.out.println("log Around end.....");
    }
}
