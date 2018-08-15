package com.xiaohaier66.Stream;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InitStream {
    public static void main(String[] args) {
        Stream<String> stream = initByBuilder();
        stream.forEach(System.out::println);

        Stream<String> stream2 = initByCollection();
        stream2.forEach(System.out::print);

        Stream<String> stream3 = Stream.empty();
        stream3.forEach(System.out::println);

        IntStream stream4 = IntStream.rangeClosed(1,5);
        stream4.forEach(System.out::print);
    }

    private static Stream<String> initByBuilder(){
        return Stream.<String>builder()
                .add("Web ")
                .add("java ")
                .add("c ")
                .add("c# ")
                .add("c++ ")
                .build();

    }

    private static Stream<String> initByCollection(){
        Set<String> names = new HashSet<>();
        names.add("java");
        names.add("Dharma");
        names.add("2018");
        names.add("(2)");

        return names.stream();
    }
}
