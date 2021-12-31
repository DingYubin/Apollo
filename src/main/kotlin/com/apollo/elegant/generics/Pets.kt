package com.apollo.elegant.generics

class Pets {
    abstract class Pet(var name: String)

    class Cat(name: String) : Pet(name)

    class Dog(name: String) : Pet(name)

    class Fish(name: String) : Pet(name)

    /**
     * Vet<in T> 协变点
     */
    class Contest<T: Pet>(var vet: Vet<in T>) {

        private val scores: MutableMap<T, Int> = mutableMapOf()
        fun addScore(t: T, score: Int = 0) {
            if (score >= 0) scores[t] = score
        }

        fun getWinners(): MutableSet<T> {
            val winners: MutableSet<T> = mutableSetOf()
            val highScore = scores.values.maxOrNull()
            for ((t, score) in scores) {
                if (score == highScore) winners.add(t)
            }
            return winners
        }
    }

    /**
     * 协变：子类型可以替换父类型
     * 只能被用于“输出”，例如方法的返回类型
     * <out T> -> <T extends Pet>
     */
    interface Retailer<out T> {
        fun sell() : T
    }

    class CatRetailer : Retailer<Cat>{
        override fun sell(): Cat {
            println("Sell Cat")
            return Cat("")
        }
    }

    class DogRetailer : Retailer<Dog>{
        override fun sell(): Dog {
            println("Sell Dog")
            return Dog("")
        }
    }

    class FishRetailer : Retailer<Fish> {
        override fun sell(): Fish {
            println("Sell Fish")
            return Fish("")
        }
    }

    /**
     * 逆变：父类型代替子类型
     * 只能被用于“输入”，例如方法的参数类型
     * <int T> -> <Pet super T>
     */
//    class Vet<in T: Pet> {
    class Vet<T: Pet> {
        fun treat(t: T) {
            println("Treat Pet ${t.name}")
        }
    }

}

fun main() {
    val catFuzz = Pets.Cat("Fuzz LightYear")
    val catKatSu = Pets.Cat("KatSu")
    val fishFinny = Pets.Fish("Finny McGraw")

    val petVet = Pets.Vet<Pets.Pet>()
    petVet.treat(Pets.Cat("KatSu"))

    val catVet = Pets.Vet<Pets.Cat>()
    catVet.treat(Pets.Cat("Fuzz LightYear"))

    val fishVet = Pets.Vet<Pets.Fish>()
    fishVet.treat(fishFinny)

    val catContest = Pets.Contest<Pets.Cat>(catVet)
    catContest.addScore(catFuzz, 50)
    catContest.addScore(catKatSu, 45)
    val topCat = catContest.getWinners().first()
    println("Cat contest winner is ${topCat.name}")

    val petContest = Pets.Contest<Pets.Pet>(petVet)
    petContest.addScore(catFuzz, 50)
    petContest.addScore(fishFinny, 56)
    val topPet = petContest.getWinners().first()
    println("Pet contest winner is ${topPet.name}")

    val fishContest = Pets.Contest<Pets.Fish>(petVet)

    val dogRetailer : Pets.Retailer<Pets.Dog> = Pets.DogRetailer()
    val catRetailer : Pets.Retailer<Pets.Cat> = Pets.CatRetailer()
    val petRetailer : Pets.Retailer<Pets.Pet> = Pets.CatRetailer()
    petRetailer.sell()
}