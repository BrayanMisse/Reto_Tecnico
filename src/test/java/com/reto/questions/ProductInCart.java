package com.reto.questions;

import com.reto.ui.ShoppingCartElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;

public class ProductInCart implements Question<Boolean> {

    private final String productName;

    public ProductInCart(String productName) {
        this.productName = productName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Check for the presence of the target representing the product in the cart.
        // ATENCION: Depende de que el método itemInCart en ShoppingCartElements sea correcto.
        return Presence.of(ShoppingCartElements.itemInCart(productName)).answeredBy(actor);
    }

    public static Question<Boolean> called(String productName) {
        return new ProductInCart(productName);
    }
} 