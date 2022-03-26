package com.apollo.elegant.generics.list;

import com.apollo.elegant.generics.list.iml.SupperMapper;

public class MapTest {

    public static void main(String[] args) {
        SupperMappableList<Integer> ml = new SupperMappableList<>();
        for (int i = 1; i <= 5; i++) {
            ml.add(i);
        }
//        SupperMappableList<String> rel = ml.map(new SupperMapper<Integer, String>() {
//            @Override
//            public String map(Integer val) {
//                return "rel : " + val;
//            }
//        });
        SupperMappableList<String> res = ml.map(val -> "hello" + val);

        System.out.println(res);
    }
}
