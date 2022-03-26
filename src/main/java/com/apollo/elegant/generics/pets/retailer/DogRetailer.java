package com.apollo.elegant.generics.pets.retailer;

import com.apollo.elegant.generics.pets.iml.Retailer;
import com.apollo.elegant.generics.pets.pet.Dog;

public class DogRetailer implements Retailer<Dog> {

    @Override
    public Dog sell() {
        System.out.println("Sell Dog");
        return new Dog("DogR");
    }
}
