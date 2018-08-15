package com.xiaohaier66.Lambda;

interface Coffee2{
    void service(String shop, String name);
}

public class IceCoffee2 {
    public static void main(String[] args) {
        int size = 10;
        Coffee2 order = (shop,name) ->
                System.out.println(
                        shop+ " order: " + name + "name");

        size = 9;

//        Effectively Final;
        order.service("startbucks","latts");
    }
}
