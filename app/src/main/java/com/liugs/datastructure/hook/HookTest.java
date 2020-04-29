package com.liugs.datastructure.hook;

import java.lang.reflect.Proxy;

public class HookTest {

    public static void main(String[] args) {
        IDevelop joker = new JokerDevelop();
        IDevelop proxyInstance = (IDevelop) Proxy.newProxyInstance(joker.getClass().getClassLoader(), joker.getClass().getInterfaces(), new ProxyHandle(joker));
        proxyInstance.code();
        proxyInstance.debug();
    }
}
