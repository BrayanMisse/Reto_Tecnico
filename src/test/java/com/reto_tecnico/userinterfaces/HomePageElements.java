package com.reto_tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePageElements {

    public static final Target CATEGORY_LINK = Target.the("category link")
            .locatedBy("//a[contains(text(),'{0}')]"); // Assuming category links can be found by text

    public static final Target CART_COUNT = Target.the("cart count")
            .locatedBy(".cart-count"); // Assuming a class for the cart count element

} 