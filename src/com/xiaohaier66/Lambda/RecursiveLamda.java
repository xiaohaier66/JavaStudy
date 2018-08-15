package com.xiaohaier66.Lambda;
import java.util.function.*;


import java.util.function.IntFunction;

public class RecursiveLamda {
    private static long factorial(int n){
        if(n == 1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }



    public static void main(String[] args) {
        System.out.println(factorial(5));

        IntFunction<Long> factorialCal = n -> factorial(n);
        System.out.println(factorialCal.apply(10));
    }


}
