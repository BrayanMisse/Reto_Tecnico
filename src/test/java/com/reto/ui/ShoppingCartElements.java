package com.reto.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCartElements {

    // Target para el contador de items en el carrito.
    // Este es un EJEMPLO. Debes inspeccionar la página para encontrar el localizador correcto.
    public static final Target SHOPPING_CART_ICON_WITH_COUNT = Target.the("icono del carrito con contador")
            .locatedBy("//span[contains(@class, 'cart-contents-count')]");

    // Target para la lista o contenedor de items dentro del carrito (si es visible en la misma página o en un popup).
    // Este es un EJEMPLO. Debes inspeccionar la página para encontrar el localizador correcto.
    public static final Target SHOPPING_CART_ITEMS_LIST = Target.the("lista de items en el carrito")
            .locatedBy("//div[contains(@class, 'widget_shopping_cart_content')]");

    // Target genérico para un item de producto dentro de la lista del carrito.
    // Este es un EJEMPLO. Debes inspeccionar la página para encontrar el localizador correcto y adaptarlo.
    public static final Target SHOPPING_CART_ITEM = Target.the("item en el carrito")
            .locatedBy(".//li[contains(@class, 'mini_cart_item')]");

    // Target para el nombre o título de un producto dentro de un item del carrito.
    // Este es un EJEMPLO. Debes inspeccionar la página para encontrar el localizador correcto y adaptarlo.
     public static final Target SHOPPING_CART_ITEM_TITLE = Target.the("título del item en el carrito")
            .locatedBy(".//a[contains(@class, 'remove_from_cart_button')]/following-sibling::a");

    // Target para el botón de eliminar dentro de un item del carrito.
    public static final Target REMOVE_ITEM_BUTTON = Target.the("botón de eliminar item")
            .locatedBy(".//a[contains(@class, 'remove_from_cart_button')]");

    // Método para obtener el Target de un item específico en el carrito por su nombre.
    // ATENCION: Depende de que los localizadores anteriores sean correctos.
    public static Target itemInCart(String productName) {
        // Busca un item en el carrito que contenga el título especificado.
        return Target.the("producto " + productName + " en el carrito")
                .locatedBy(String.format("//li[contains(@class, 'mini_cart_item') and .//a[contains(@class, 'remove_from_cart_button')]/following-sibling::a[text()='%s']]", productName));
        // <<< ESTE LOCALIZADOR TAMBIEN DEBE SER AJUSTADO
    }

    // Método para obtener el Target del botón de eliminar para un producto específico por su nombre.
    public static Target removeItemButtonForProduct(String productName) {
         return Target.the("botón de eliminar para el producto " + productName)
                 .locatedBy(String.format("//li[contains(@class, 'mini_cart_item') and .//a[contains(@class, 'remove_from_cart_button')]/following-sibling::a[text()='%s']]//a[contains(@class, 'remove_from_cart_button')]", productName));
    }

} 