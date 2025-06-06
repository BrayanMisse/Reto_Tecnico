package com.reto.questions;

import com.reto.ui.ShoppingCartElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class NumberOfItemsInCart implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        // Read the text from the cart count element and parse it as an integer.
        // ATENCION: Asegúrate de que el Target SHOPPING_CART_ICON_WITH_COUNT
        // realmente apunte a un elemento que contenga solo el número de items.
        String itemCountText = Text.of(ShoppingCartElements.SHOPPING_CART_ICON_WITH_COUNT).answeredBy(actor);
        try {
            return Integer.parseInt(itemCountText.trim());
        } catch (NumberFormatException e) {
            // Handle cases where the text is not a valid number (e.g., empty cart might show different text)
            // For now, returning 0 or throwing an exception depending on desired behavior.
            System.err.println("Could not parse cart item count: " + itemCountText);
            return 0; // Or throw new RuntimeException("Invalid cart count text: " + itemCountText, e);
        }
    }

    public static Question<Integer> displayed() {
        return new NumberOfItemsInCart();
    }
} 