package com.coderme.design.proxy.jdkdynamic;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author qiudm
 * @date 2018/9/25 18:15
 * @desc
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(final Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理买房前" );
        Object invoke = method.invoke(object, args);
        System.out.println("动态代理买房后" );
        return invoke;
    }
}
