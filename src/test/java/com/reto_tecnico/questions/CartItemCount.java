package com.reto_tecnico.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartItemCount implements Question<Integer> {

    // Assuming the cart item count is displayed in an element with a specific class or ID.
    // This locator may need to be adjusted based on the actual website HTML.
    private static final Target CART_COUNT_ELEMENT = Target.the("cart item count").located(By.cssSelector(".cart-count"));

    @Override
    public Integer answeredBy(net.serenitybdd.screenplay.Actor actor) {
        String countText = Text.of(CART_COUNT_ELEMENT).answeredBy(actor).trim();
        try {
            return Integer.parseInt(countText);
        } catch (NumberFormatException e) {
            return 0; // Return 0 if the text is not a valid number
        }
    }

    public static CartItemCount displayed() {
        return new CartItemCount();
    }
} 