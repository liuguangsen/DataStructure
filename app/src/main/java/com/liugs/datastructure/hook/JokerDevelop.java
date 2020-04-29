package com.liugs.datastructure.hook;

public class JokerDevelop implements IDevelop {
    @Override
    public void code() {
        System.out.println("Joker is code.");
    }

    @Override
    public void debug() {
        System.out.println("Joker is debugging. some error.");
    }
}
