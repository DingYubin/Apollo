package com.apollo.elegant.experiment;

import java.util.ArrayList;

public class StringGenerator {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        //Method Reference ::  --> 方法的引用
        arr.toArray(new String[0]);
        //Lazy evaluation --> 惰性计算 （函数式编程 -> lambda表达式）
//        arr.toArray(String[]::new);
    }
}
