package com.apollo.elegant.generics.pets.iml;

import com.apollo.elegant.generics.pets.abs.Pet;

/**
 * 协变：子类型可以替换父类型
 * 只能被用于“输出”，例如方法的返回类型
 * <T extends Pet>
 */
public interface Retailer<T extends Pet> {

    T sell();
}
