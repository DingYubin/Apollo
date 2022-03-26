package com.apollo.elegant.generics.pets.retailer;

import com.apollo.elegant.generics.pets.iml.Retailer;
import com.apollo.elegant.generics.pets.pet.Fish;

public class FishRetailer implements Retailer<Fish> {

    @Override
    public Fish sell() {
        System.out.println("Sell Fish");
        return new Fish("FishR");
    }
}
