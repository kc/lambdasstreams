package com.example.lambdas;

public class MyMath {

    public final int i;

    public MyMath() { i = -1; }

    public MyMath(int i) { this.i = i; }

    public static int x(int a) { return a + 1; } // pure function

    public int y(int a) { return this.i + a; } // instance method, operates on objects' state

}
