package com.apollo.elegant.generics.list.iml;

public interface SupperMapper<T, U> {
    U map(T val);
}
