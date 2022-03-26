package com.apollo.elegant.generics.pets;

import com.apollo.elegant.generics.pets.abs.Pet;
import org.jetbrains.annotations.NotNull;

/**
 * 逆变：父类型代替子类型
 * 只能被用于“输入”，例如方法的参数类型
 */
public class Vet<T extends Pet> {

    void treat(@NotNull T t) {
        System.out.println("Treat Pet" + t.getName());
    }
}
