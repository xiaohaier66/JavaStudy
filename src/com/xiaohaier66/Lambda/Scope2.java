package com.xiaohaier66.Lambda;

import java.util.function.Function;

public class Scope2 {
    private static int a;
    public static int b;
    private Scope2() {
        Function<String,String> func = x -> {
            System.out.println(this);
            return x;
        };
        System.out.println(func.apply("Dharma"));
    }

    public static void main(String[] args) {
//        System.out.println(this.a);
        System.out.println(a);
//        System.out.println(this.b);
        System.out.println(b);

        new Scope2();
    }
}
