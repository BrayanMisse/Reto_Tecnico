package com.reto_tecnico.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.converters.GridConverter;

import static com.reto_tecnico.userinterfaces.HomePageElements.CART_COUNT;

public class CartItemCount implements Question<Integer> {

    public static CartItemCount displayed() {
        return new CartItemCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        String countText = Text.of(CART_COUNT).answeredBy(actor);
        try {
            return Integer.parseInt(countText.trim());
        } catch (NumberFormatException e) {
            // Handle the case where the text is not a valid number
            System.err.println("Could not parse cart count as integer: " + countText);
            return 0; // Return 0 or throw an exception, depending on desired behavior
        }
    }
} 