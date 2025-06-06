package com.reto_tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CategoryPageElements {

    public static final Target PRODUCT_ITEM = Target.the("product item")
            .locatedBy(".product-item"); // Assuming a class for product items

    public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button")
            .locatedBy(".add-to-cart-button"); // Assuming a class for the add to cart button within a product item

} 