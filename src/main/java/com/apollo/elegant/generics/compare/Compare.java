package com.apollo.elegant.generics.compare;

public class Compare {

    /**
     * 1、如果是extends 有抽象类，需要放在第一个位置，可以用 & 分割
     * 2、java泛型中不存在 T super Comparable<T> 这种形式的限定
     * 编译期间 可以限定类型
     * 限定 类型 T
     * @param arr 传入 T[]类型 参数
     * @param <T> 传入T类型 值
     * return 数组中最小值
     */
    public static <T extends Comparable<T>> T min(T[] arr) {
        T minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minVal.compareTo(arr[i]) > 0) {
                minVal = arr[i];
            }
        }
        return minVal;
    }

}
