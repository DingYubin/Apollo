package com.apollo.elegant.generics.compare;

public class CompareTest {

    public static void main(String[] args) {

        Integer[] num = {5, 3, 2, 1, 10};
        int minVal = Compare.min(num);
        System.out.println("最小值是：" + minVal);
    }
}
