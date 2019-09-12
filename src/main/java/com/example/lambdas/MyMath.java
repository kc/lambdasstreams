package com.example.lambdas;

public class MyMath {

    public final int i;

    public MyMath(int i) { this.i = i; }

    public static int x(int a) { return a + 1; }

    public void y(int i) { System.out.println("Hap" + i); }

    public void z(int i) { System.out.println("Yummie" + this.i + i); }
}
