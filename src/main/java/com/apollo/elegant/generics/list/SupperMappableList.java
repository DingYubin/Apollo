package com.apollo.elegant.generics.list;

import com.apollo.elegant.generics.list.iml.SupperMapper;

import java.util.ArrayList;

public class SupperMappableList<T> extends ArrayList<T> {
    /**
     * 将T类型转换到U类型到 map操作
     * @param <U> 第一U指代 声明泛型方法
     * {SupperMapper<T,U>} 类型参数
     * @return U 类型 集合
     */
    public <U> SupperMappableList<U> map(SupperMapper<T, U> mapper) {
        SupperMappableList<U> res = new SupperMappableList<>();
        for (T e: this) {
            res.add(mapper.map(e));
        }
        return res;
    }

}
