package com.reto_tecnico.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddSelectedProductsToCart implements Task {

    // Assuming a common structure for product listings and add to cart buttons.
    // These locators may need to be adjusted based on the actual website HTML.
    private static final Target PRODUCT_ITEM = Target.the("product item").located(By.cssSelector(".product-item"));
    private static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button").located(By.cssSelector(".add-to-cart"));

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PRODUCT_ITEM, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ADD_TO_CART_BUTTON.resolveAllFor(actor).get(0)),
                Click.on(ADD_TO_CART_BUTTON.resolveAllFor(actor).get(1))
        );
    }

    public static Performable theFirstTwo() {
        return instrumented(AddSelectedProductsToCart.class);
    }
} 