package com.apollo.elegant.generics;

import com.apollo.elegant.generics.pets.abs.Pet;
import com.apollo.elegant.generics.pets.pet.Cat;
import com.apollo.elegant.generics.pets.pet.Dog;
import com.apollo.elegant.generics.pets.pet.Fish;

import java.util.ArrayList;
import java.util.List;

import static com.apollo.elegant.generics.pets.PetUtils.*;

public class Generics {

    public static void main(String[] args) {

        Cat helloCat = new Cat("小花");
        Pet pet = new Cat("小花");
        System.out.println("cat : " + helloCat.getName() + ", pet : " + pet.getName());

        //协变 只能取，不能存
        List<? extends Pet> extendsPets = new ArrayList<Cat>();
//        pets.add(new Cat("小明")); 报错，不能添加
        if (extendsPets.size() > 0) {
            Pet cat = extendsPets.get(0);
        }

        //逆变 只能存，不能取
        List<? super Cat> superPets = new ArrayList<Pet>();
        superPets.add(new Cat("小花"));
//        superPets.forEach(cat -> System.out.println(cat.getName())); 报错，不能取出

        //场景1 泛型擦除 编译不过
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("小猫A"));
        cats.add(new Cat("小猫B"));
        printPets1(cats);

        //使用场景2 可以定义出不同子类
        List<Pet> pets = new ArrayList<>();
        setPets(pets);
        printPets(pets);

        //使用场景3
        Cat catPet = new Cat("毛毛");
        getAnName(catPet);
    }

}
