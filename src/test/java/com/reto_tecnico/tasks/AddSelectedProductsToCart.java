package com.reto_tecnico.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import static com.reto_tecnico.userinterfaces.CategoryPageElements.PRODUCT_ITEM;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.util.List;

public class AddSelectedProductsToCart implements Task {

    // Definir el localizador para el botón de añadir al carrito relativo a un ítem de producto
    private static final By ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR = By.cssSelector(".add-to-cart-button"); // Usar By

    public static AddSelectedProductsToCart now() {
        return new AddSelectedProductsToCart();
    }

    @Override
    @Step("{0} adds the selected products to the shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PRODUCT_ITEM, isVisible()).forNoMoreThan(10).seconds()
        );

        List<WebElementFacade> products = PRODUCT_ITEM.resolveAllFor(actor);

        if (products.size() >= 2) {
            // Click the add to cart buttons for the first two products
            for (int i = 0; i < 2; i++) {
                 WebElementFacade productItem = products.get(i);
                 actor.attemptsTo(
                     // Intentando usar Click.on() con el elemento encontrado dentro del WebElementFacade
                     Click.on(productItem.find(ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR))
                 );
            }

        } else {
            System.out.println("Warning: Less than two products available on the page to add to cart.");
        }
    }
} 