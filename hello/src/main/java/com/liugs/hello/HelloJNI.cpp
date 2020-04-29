//
// Created by liugstick on 2020/4/28.
//

#include <jni.h>       // JNI header provided by JDK
#include <iostream>    // C++ standard IO header
#include "HelloJNI.h"  // Generated
using namespace std;

// Implementation of the native method sayHello()
JNIEXPORT void JNICALL Java_com_liugs_hello_HelloJNI_sayHello(JNIEnv *env, jobject thisObj) {
	cout << "Hello World from C++!" << endl;
   return;
}