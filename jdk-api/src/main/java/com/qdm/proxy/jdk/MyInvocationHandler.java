package com.qdm.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qiudm
 * @date 2018/8/15 14:50
 * @desc
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     该方法负责集中处理动态代理类上的所有方法调用。
     第一个参数既是代理类实例，
     第二个参数是被调用的方法对象
     第三个方法是调用参数。
     调用处理器根据这三个参数进行预处理或分派到委托类实例上发射执行
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理");
        System.out.println("方法执行前调用");
        Object result = method.invoke(target, args);
        System.out.println("方法执行后调用");
        return result;
    }


    public static void main(String[] args) {
        UserService userService = new UserService();
        UserService2 userService2 = new UserService2();

        IUserService proxyUserService = (IUserService) Proxy.newProxyInstance(IUserService.class.getClassLoader(),
                new Class[]{IUserService.class},
                new MyInvocationHandler(userService));

        IUserService proxyUserService2 = (IUserService) Proxy.newProxyInstance(IUserService.class.getClassLoader(),
                new Class[]{IUserService.class},
                new MyInvocationHandler(userService2));

        proxyUserService.getUserName();
        System.out.println(" = = = = = = = = = = = = =" );
        proxyUserService2.getUserName();

    }






}
