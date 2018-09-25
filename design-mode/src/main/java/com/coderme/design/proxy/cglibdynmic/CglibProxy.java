package com.coderme.design.proxy.cglibdynmic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author qiudm
 * @date 2018/9/25 18:24
 * @desc
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;
    public Object getInstance(final Object target) {
        this.target = target; //给业务对象赋值
        Enhancer enhancer = new Enhancer();//创建加强器，用来创建动态代理类
        enhancer.setSuperclass(this.target.getClass()); //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return enhancer.create();
    }

    // 实现回调方法
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("Cglib买房前准备");
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("Cglib买房后装修");
        return result;
    }



}
