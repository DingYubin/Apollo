package com.apollo.elegant.generics.pets.retailer;

import com.apollo.elegant.generics.pets.iml.Retailer;
import com.apollo.elegant.generics.pets.pet.Cat;

public class CatRetailer implements Retailer<Cat> {

    @Override
    public Cat sell() {
        System.out.println("Sell Cat");
        return new Cat("CatR");
    }
}
