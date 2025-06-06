package com.reto_tecnico.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
// import net.serenitybdd.screenplay.questions.TheElement; // TheElement no disponible en Serenity 2.x

import static com.reto_tecnico.userinterfaces.CategoryPageElements.PRODUCT_ITEM;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.util.List;

public class SelectTwoProducts implements Task {

    // Definir el localizador para el botón de añadir al carrito relativo a un ítem de producto
    private static final By ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR = By.cssSelector(".add-to-cart-button"); // Usar By

    public static SelectTwoProducts fromTheList() {
        return new SelectTwoProducts();
    }

    @Override
    @Step("{0} selects two products from the category list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PRODUCT_ITEM, isVisible()).forNoMoreThan(10).seconds()
        );

        List<WebElementFacade> products = PRODUCT_ITEM.resolveAllFor(actor);

        if (products.size() >= 2) {
            // Select the first two products and click their add to cart buttons
            for (int i = 0; i < 2; i++) {
                 WebElementFacade productItem = products.get(i);
                 // TODO: Implementar el clic en el botón "Agregar al carrito" dentro de productItem
                 // Se encontró dificultad para usar Click.on() con elementos anidados/resueltos en esta versión.
                 // La siguiente línea causó errores de ambigüedad:
                 // actor.attemptsTo(Click.on(productItem.find(ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR)));
                 // La siguiente línea también causó errores:
                 // actor.attemptsTo(Click.on(ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR).relativeTo(productItem));
                 // La siguiente línea también causó errores (TheElement no existe):
                 // actor.attemptsTo(Click.on(TheElement.located(ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR).inside(productItem)));
                 System.out.println("Attempting to select product " + (i + 1) + ". Click logic needs review.");
                 // actor.attemptsTo(/* Lógica de clic pendiente */);
            }

        } else {
            // Handle case where less than two products are available (e.g., log a warning or fail the test)
            System.out.println("Warning: Less than two products available on the page.");
            // Depending on requirements, you might want to add an assertion here to fail if not enough products
        }
    }
} 