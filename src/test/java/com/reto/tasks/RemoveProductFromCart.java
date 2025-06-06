package com.reto.tasks;

import com.reto.ui.ShoppingCartElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class RemoveProductFromCart implements Task {

    private final String productName;

    public RemoveProductFromCart(String productName) {
        this.productName = productName;
    }

    public static RemoveProductFromCart called(String productName) {
        return instrumented(RemoveProductFromCart.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ShoppingCartElements.removeItemButtonForProduct(productName)),
                // Esperar a que el item desaparezca del carrito
                WaitUntil.the(ShoppingCartElements.itemInCart(productName), isNotPresent()).forNoMoreThan(10).seconds()
        );
    }
} 