package com.apollo.elegant.generics;

import com.apollo.elegant.generics.list.SupperMappableList;

import java.util.ArrayList;

/**
 * 泛型方法
 */
public class GenericMethod {

    public <T> void print(T val) {
        System.out.println(val);
    }

    /**
     * <T, U> 用于声明 方法中含有几种类型
     * @param val 入参
     * @param <T> 入参类型
     * @param <U> 返回类型
     */
    public <T, U> U convert(T val){

        return (U)val;
    }

    public static void main(String[] args) {
        GenericMethod sm = new GenericMethod();
//        sm.<String>print("Hello");
        sm.print("Hello");
        sm.print(1);

        SupperMappableList<Integer> sml = new SupperMappableList<>();
        for (int i = 1; i <= 5; i++) {
            sml.add(i);
        }
        ArrayList<Integer> res = sm.convert(sml);
        System.out.println(res);
    }
}
