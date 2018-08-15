package com.xiaohaier66.Optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicOptional {
    public static void main(String[] args) {

        Optional<String> empty = Optional.empty();
        o(empty);

        Optional<String> name = Optional.of("ashton");
        o(name);

//        String nullString = "";
        String nullString = null;
//        Optional<String> nullStr = Optional.of(nullString);
        Optional<String> nullStr = Optional.ofNullable(nullString);
        o(nullStr);

        OptionalInt number = OptionalInt.of(2018);
        if(number.isPresent()){
            o(number.getAsInt());
        }else {
            o("number empty");
        }

        optionalStream();

    }

    private static void optionalStream(){
        OptionalInt maxOdd = IntStream
                .of(1,2,3,4)
                .filter(n -> n % 2 == 1)
                .max();
        if(maxOdd.isPresent()){
            o(maxOdd.getAsInt());
        }else {
            o("Stream is null");
        }
    }

    private static void o(Object o){
        System.out.println(o);
    }

}
