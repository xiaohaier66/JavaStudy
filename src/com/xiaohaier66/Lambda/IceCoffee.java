package com.xiaohaier66.Lambda;

@FunctionalInterface
//函数式接口中约定有且只有一个方法，主要是通过接口实现对单一独立方法的实现和调
// 用，即该接口专门为一个单一独立的函数进行创建
interface Coffee1 {
    void service(String shop, String name);
}

public class IceCoffee {
    public static void main(String[] args) {
        int size = 10;
        Coffee1 order = (shop,name) ->
                System.out.println(
                        shop+ " order: " + name + "name" + size);
//        lambda表达式与函数式接口搭配使用，以函数式编程思想
// 实现对独立方法的实现和调用

//        size = 9;
//        Variable used in lambda expression should be final or effectively final

        order.service("startbucks","latts");
    }
}
