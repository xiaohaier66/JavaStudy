package com.xiaohaier66.Lambda;

import java.util.function.Function;

public class Scope3 {
    private static int a;
    public static int b;
    private Scope3() {
        Function<String,String> func = new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println(this);
                return s;
            }

            @Override
            public String toString(){
                return "skr skr";
            }
        };
//        非lambda匿名方法中的this对应的是为方法临时实例化的对象
        System.out.println(func.apply("Dharma"));
    }

    @Override
    public String toString(){
       return "skr";
    }

    public static void main(String[] args) {

        new Scope3();
    }
}
