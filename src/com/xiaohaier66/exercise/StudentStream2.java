package com.xiaohaier66.exercise;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class StudentStream2 {
    private static List<Student> register(){
        Student s1 = new Student(1L,"ZhangHamwen",Student.Gender.MALE,100, LocalDate.of(2016, Month.SEPTEMBER,3),Student.Department.AM);
        Student s2 = new Student(2L,"SunJiaoyong",Student.Gender.FEMALE,90, LocalDate.of(2016, Month.SEPTEMBER,3),Student.Department.CL);
        Student s3 = new Student(3L,"TaoYingying",Student.Gender.FEMALE,99, LocalDate.of(2016, Month.SEPTEMBER,3),Student.Department.CS);
        Student s4 = new Student(4L,"FangJianpeng",Student.Gender.MALE,97, LocalDate.of(2016, Month.SEPTEMBER,3),Student.Department.EE);
        Student s5 = new Student(5L,"JiangHaowen",Student.Gender.MALE,96, LocalDate.of(2016, Month.SEPTEMBER,3),Student.Department.EL);
        Student s6 = new Student(6L,"NingYinqiang",Student.Gender.MALE,99, LocalDate.of(2016, Month.SEPTEMBER,3),Student.Department.CS);
        Student s7 = new Student(7L,"JiaoJianhao",Student.Gender.MALE,98, LocalDate.of(2016, Month.SEPTEMBER,3),Student.Department.AM);
        Student s8 = new Student(8L,"Fujun",Student.Gender.MALE,98, LocalDate.of(2016, Month.SEPTEMBER,3),Student.Department.CL);
        Student s9 = new Student(9L,"JiaChen",Student.Gender.MALE,95, LocalDate.of(2016, Month.SEPTEMBER,3),Student.Department.EE);

        return Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9);
    }

    private static void o(Object o){
        System.out.println(o);
    }

    private static void oo(String name,Object o){
        System.out.println();
    }

    public static void main(String[] args) {
        List<Student> students = register();

        o(students);

        //total number of students
        long studentCount = students
                .stream()
                .count();

        o("Total number of students is: " + studentCount);

        int studentSum = students
                .stream()
                .mapToInt(s -> 1)
                .sum();
        o("Total number(sum) of students is: " + studentCount);

        //Total credit
        int totalCredits = students
                .stream()
                .mapToInt(Student::getCredit)
                .sum();
        o("Total credits of students is: "+totalCredits);

        //Student number by gender
        Map<Student.Gender,Long> groupCountGender =
                students.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.counting())
                );

        o("Student group gender is:" + groupCountGender);

        //Student with best credits
        Optional<Student> studentWithMaxCredit =
                students.stream()
//                .max((s1,s2) -> s1.getCredit() - s2.getCredit());
                .max(Comparator.comparing(Student::getCredit));
        if(studentWithMaxCredit.isPresent()){
            o("Student with max credit is: " + studentWithMaxCredit.get().getName());
            o("Max credit is: "+studentWithMaxCredit.get().getCredit());
        }else {
            o("Can not find such student");
        }

        //Sum of credits
        Integer sumCredit = students.stream()
//                串行计算，没有合并操作，后边的合并类操作reduce单纯将中间值得整型变成一个可接受的类型
                .reduce(0,
                        (Integer middleSum,Student student)->{
                    o(Thread.currentThread().getName()+" "+
                    student.getName()+" "+
                    student.getCredit());
                    return middleSum + student.getCredit();
                        },
                        (a,b) -> {
                    o(Thread.currentThread().getName());
                    //单纯把中间值的整型变成一个可接受的类型，下一行并不返回有效值
                    return null;
                        });



    }
}
