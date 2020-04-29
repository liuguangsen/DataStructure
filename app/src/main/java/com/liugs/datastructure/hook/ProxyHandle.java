package com.liugs.datastructure.hook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandle implements InvocationHandler {

    private IDevelop develop;

    public ProxyHandle(IDevelop develop) {
        this.develop = develop;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("code")){
            System.out.println("Joker is preparing code.");
           return method.invoke(develop,args);
        } else if (method.getName().equals("debug")){
            System.out.println("Joker no bug. No need to debug!");
            return null;
        }
        return null;
    }
}
