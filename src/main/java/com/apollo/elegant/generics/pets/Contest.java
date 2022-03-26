package com.apollo.elegant.generics.pets;

import com.apollo.elegant.generics.pets.abs.Pet;

import java.util.*;

/**
 * 协变
 * @param <T> 协变点 T extends Pet
 */
public class Contest<T extends Pet> {

    private Vet<Pet> vet;

    public Contest(Vet<Pet> vet) {
        this.vet = vet;
    }

    private final Map<T, Integer> scores = new HashMap<>();

    public void addScore(T t, int score) {
        if (score >= 0) {
            scores.put(t, score);
        }
    }

    public Set<T> getWinners(){
        final Set<T> winners = new HashSet<>();
        final int highScore = Collections.max(scores.values());

        scores.forEach((t , score) -> {
            if (score == highScore) winners.add(t);
        });

//      scores.entrySet().stream()
//                .filter(entry -> entry.getValue() == highScore)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toSet());

        return winners;
    }
}
