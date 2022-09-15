package com.apollo.elegant

import java.util.*
import kotlin.collections.ArrayList

object SortTest1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val list: MutableList<Dog> = ArrayList()
        list.add(Dog(6.5f, "DogA","59.90"))
        list.add(Dog(8.5f, "DogB","40.61"))
        list.add(Dog(7.5f, "DogC","20.42"))
        list.add(Dog(7.5f, "DogD","30.55"))
        list.add(Dog(7.5f, "DogE","10.32"))

        val arrays : MutableList<List<Dog>> = ArrayList()
        arrays.add(list)
//        list.sortWith(DogComparator())
        val list1 = list.sortedWith(DogComparator())
        println("给狗狗按照年龄倒序：$list1")
        arrays.clear()
        arrays.add(list1)
        println("给狗狗按照年龄倒序：$arrays")
//        arrays.flatten().sortedWith(DogComparator())
//        arrays.forEach{
//            it.sortedWith(DogComparator())
//            it.sortWith(DogComparator())
//        }
//        println("给狗狗按照年龄倒序：$arrays")
//        val comparab = list.distinctBy { it.age }
//        println("去重复：$comparab")

//        Collections.sort(list) { o1, o2 ->
//            (o1.age - o2.age).toInt()
//                            if (o1.age > o2.age){
//                    return -1;
//                } else if (o1.age < o2.age){
//                    return 1;
//                } else {
//                    return 0;
//                }
//        }
//        list.sortWith(DogComparator())


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

class DogComparator : Comparator<Dog> {
    override fun compare(o1: Dog?, o2: Dog?): Int {
        return o1?.sortValue?.toBigDecimal()?.compareTo(o2?.sortValue?.toBigDecimal())?:0
    }
}

class Dog(var age: Float, var name: String, var sortValue: String) {
    override fun toString(): String {
        return "Dog [age=$age, name=$name, sortValue=$sortValue]"
    }
}