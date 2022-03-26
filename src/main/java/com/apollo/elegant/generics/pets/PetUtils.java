package com.apollo.elegant.generics.pets;

import com.apollo.elegant.generics.pets.abs.Pet;
import com.apollo.elegant.generics.pets.pet.Cat;
import com.apollo.elegant.generics.pets.pet.Dog;
import com.apollo.elegant.generics.pets.pet.Fish;

import java.util.List;

public class PetUtils {

    /**
     * 限定方法
     * @param pet
     * @param <T>
     * @return
     */
    public static <T extends Pet<T>> String getAnName(T pet) {

        return pet.getTName(pet);
    }

    /**
     * ？super Pet 受限通配符 下限
     * 泛型做为参数传入 添加
     * 逆变点
     */
    public static void setPets(List<? super Pet> superPets) {
        superPets.add(new Dog("小狗"));
        superPets.add(new Cat("小猫"));
        superPets.add(new Fish("小鱼"));
    }

    /**
     * ？extends Pet 受限通配符 上限
     * 泛型作为参数传入 获取
     * 协变点
     */
    public static void printPets(List<? extends Pet> extendsPets) {
        extendsPets.forEach(pet -> System.out.println(pet.getName()));
    }

    /**
     * ？ 不能做任何事情
     */
    public static void printPets1(List<?> pets) {
//        pets.forEach(pet -> pet.getName()); 不允许调用对象自己到方法
        pets.forEach(System.out::println);
    }

}
