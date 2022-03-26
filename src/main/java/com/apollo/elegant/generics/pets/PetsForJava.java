package com.apollo.elegant.generics.pets;

import com.apollo.elegant.generics.pets.abs.Pet;
import com.apollo.elegant.generics.pets.iml.Retailer;
import com.apollo.elegant.generics.pets.pet.Cat;
import com.apollo.elegant.generics.pets.pet.Dog;
import com.apollo.elegant.generics.pets.pet.Fish;
import com.apollo.elegant.generics.pets.retailer.CatRetailer;
import com.apollo.elegant.generics.pets.retailer.DogRetailer;

public class PetsForJava {

    public static void main(String[] args) {

        Cat catFuzz = new Cat("Fuzz LightYear");
        Cat catKatSu = new Cat("KatSu");
        Fish fishFinny = new Fish("Finny McGraw");

        Vet<Pet> petVet = new Vet<>();
        petVet.treat(catKatSu);

        Vet<Pet> catVet = new Vet<>();
        catVet.treat(catFuzz);

        Vet<Pet> fishVet = new Vet<>();
        fishVet.treat(fishFinny);

        Contest<Pet> catContest = new Contest<>(catVet);
        catContest.addScore(catFuzz, 50);
        catContest.addScore(catKatSu, 40);
        catContest.addScore(fishFinny, 60);
        Pet cat = catContest.getWinners().stream().findFirst().get();
        System.out.println("Pet contest winner is " + cat.getName());

        Retailer<Dog> dogRetailer = new DogRetailer();
        Retailer<Cat> catRetailer = new CatRetailer();
        Retailer<? extends Pet> petRetailer = new CatRetailer();
        petRetailer.sell();
    }
}
