package com.xiaohaier66.Lambda;

import java.util.function.Function;

public class Scope {
    private static int a;
    public static int b;
    private Scope() {
        Function<String,String> func = x -> {
            System.out.println(this);
//            打印this实际是调用this对应对象的toString方法
            return x;
        };
//        lambda没有scope的概念，其对应的匿名类中使用this对应的是lambda表达式所在的类
        System.out.println(func.apply("Dharma"));
    }

    @Override
    public String toString(){
       return "skr";
    }

    public static void main(String[] args) {

        new Scope();
    }
}
