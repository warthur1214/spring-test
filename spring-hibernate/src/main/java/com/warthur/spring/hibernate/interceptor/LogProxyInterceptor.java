package com.warthur.spring.hibernate.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by warthur on 17/7/15.
 */
public class LogProxyInterceptor implements InvocationHandler {

    private Object target;

    public LogProxyInterceptor(Object target) {
        this.target = target;
    }

    private void beforeMethod(Method method) {
        System.out.println( method.getName() + ": log start........");
    }

    private void endMethod(Method method) {
        System.out.println(method.getName() + ": log end........");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        beforeMethod(method);
        method.invoke(target, args);
        endMethod(method);

        return null;
    }
}
