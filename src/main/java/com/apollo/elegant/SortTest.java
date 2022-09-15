package com.apollo.elegant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    class Dog{
        public float age;
        public String name;
        public Dog(float age, String name) {
            super();
            this.age = age;
            this.name = name;
        }
        @Override
        public String toString() {
            return "Dog [age=" + age + ", name=" + name + "]";
        }
    }
    public static void main(String[] args) {
        List<Dog> list= new ArrayList<>();
        list.add(new SortTest().new Dog(6.5f, "DogA"));
        list.add(new SortTest().new Dog(8.5f, "DogB"));
        list.add(new SortTest().new Dog(7.5f, "DogC"));
        list.add(new SortTest().new Dog(7.5f, "DogD"));
        list.add(new SortTest().new Dog(7.5f, "DogE"));
        Collections.sort(list, new Comparator<Dog>() {

            @Override
            public int compare(Dog o1, Dog o2) {
                return (int) (o1.age - o2.age);
//                if (o1.age > o2.age){
//                    return -1;
//                } else if (o1.age < o2.age){
//                    return 1;
//                } else {
//                    return 0;
//                }
            }
        });
        System.out.println("给狗狗按照年龄倒序："+list);
//        Collections.sort(list, new Comparator<Dog>() {
//
//            @Override
//            public int compare(Dog o1, Dog o2) {
//                return o1.name.compareTo(o2.name);
//            }
//        });
//        System.out.println("给狗狗按名字字母顺序排序："+list);
    }
}
