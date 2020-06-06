package com.liugs.hello;

import java.util.HashMap;

public class HelloJNI {
    static {
//        System.loadLibrary("hello"); // Load native library hello.dll (Windows) or libhello.so (Unixes)
        //  at runtime
        // This library contains a native method called sayHello()
    }

    // Declare an instance native method sayHello() which receives no parameter and returns void
    private native void sayHello();

    // Test Driver
    public static void main(String[] args) {
//        new HelloJNI().sayHello();  // Create an instance and invoke the native method

        int h = 2;
        int i = -20 >>> 2;
                //-2 >> 1;
        System.out.println(i);
    }
}
