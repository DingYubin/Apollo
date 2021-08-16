package com.apollo.elegant.generics

class Pets {
    abstract class Pet(var name: String)

    class Cat(name: String) : Pet(name)

    class Dog(name: String) : Pet(name)

    class Fish(name: String) : Pet(name)

    class Contest<T: Pet> {
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
}

fun main() {
    val catFuzz = Pets.Cat("Fuzz LightYear")
    val catKatSu = Pets.Cat("KatSu")
    val fishFinny = Pets.Fish("Finny McGraw")

    val catContest = Pets.Contest<Pets.Cat>()
    catContest.addScore(catFuzz, 50)
    catContest.addScore(catKatSu, 45)
    val topCat = catContest.getWinners().first()
    println("Cat contest winner is ${topCat.name}")

    val petContest = Pets.Contest<Pets.Pet>()
    petContest.addScore(catFuzz, 50)
    petContest.addScore(fishFinny, 56)
    val topPet = petContest.getWinners().first()
    println("Pet contest winner is ${topPet.name}")
}