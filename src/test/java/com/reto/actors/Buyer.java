package com.reto.actors;

import net.serenitybdd.screenplay.Actor;

public class Buyer extends Actor {

    public static Buyer called(String actorName) {
        return Actor.named(actorName).ofType(Buyer.class);
    }
} 