package com.xiaohaier66.Stream;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class OperateStream {
    public static void main(String[] args) {
        runMap();
        runFlatMap();
        runPeek();

        runStat();
    }
    private static void runMap(){
        DoubleStream.of(1.5,2.8,3.2,10,90)
                .map(Math::cos)
//                .map(x -> x*2)
                .forEach(System.out::println);
    }

    private static void runFlatMap(){
        IntStream.range(1,10)
                .flatMap(n -> IntStream.of(n,n*n))
                .forEach(System.out::println);
        DoubleStream.of(1.5,2.8,3.2,10,90)
                .map(x -> x*2)
                .forEach(System.out::println);

    }

    private static void runPeek(){
        IntStream.rangeClosed(1,5)
                .peek(x -> System.out.println("Original integer: "+x))
                .filter(n -> n % 2 == 1)
                .peek(x -> System.out.println("Filtered integer: "+ x))
                .mapToDouble(Math::sqrt)
                .peek(x -> System.out.println("Mapped double:" + x))
                .sum();
    }

    private void o(Object o){
        System.out.println(o);
    }

    private static void runReduce(){
        int sum = IntStream.rangeClosed(1,5)
                .reduce(10,((left, right) -> {
                    System.out.print(left);
                    System.out.print(right);
                    return left+right;
                }));
    }

    private static void runStat(){
        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
        stats.accept(100.0);
        stats.accept(300.0);
        stats.accept(1823.0);
        stats.accept(923.0);
        stats.accept(32.5);
        stats.accept(422.0);

        long count = stats.getCount();
        double sum = stats.getSum();
        double avg = stats.getAverage();
        double min = stats.getMin();
        double max = stats.getMax();
        System.out.print(""
                +" count: "+count
                +" sum: "+sum
                +" avg: "+avg
                +" max: "+max
                +" min: "+min
        );
    }
}
