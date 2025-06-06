package com.reto.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductListingElements {

    // Target para un contenedor de producto individual en la lista.
    // Este es un EJEMPLO. Debes inspeccionar la página para encontrar el localizador correcto.
    public static final Target PRODUCT_ITEM = Target.the("item de producto")
            .locatedBy("//li[contains(@class, 'product')]");

    // Target para el botón "Agregar al Carrito" dentro de un item de producto.
    // Usamos un localizador relativo al PRODUCT_ITEM para encontrar el botón dentro de un producto específico.
    // Este es un EJEMPLO. Debes inspeccionar la página para encontrar el localizador correcto.
    public static final Target ADD_TO_CART_BUTTON = Target.the("botón Agregar al Carrito")
            .locatedBy(".//a[contains(@class, 'add_to_cart_button')]");

    // Si los productos tienen nombres o títulos visibles que se pueden usar para identificarlos,
    // puedes agregar un Target para eso también.
    public static final Target PRODUCT_TITLE = Target.the("título del producto")
            .locatedBy(".//h2[contains(@class, 'woocommerce-loop-product__title')]");

    // Método para obtener el Target del botón "Agregar al Carrito" para un producto específico por su nombre.
    // ATENCION: Depende de que los localizadores de PRODUCT_ITEM y PRODUCT_TITLE/ADD_TO_CART_BUTTON sean correctos.
    public static Target addToCartButtonForProduct(String productName) {
        // Busca el contenedor del producto que contiene el título especificado
        // y luego busca el botón "Agregar al Carrito" dentro de ese contenedor.
        return Target.the("botón Agregar al Carrito para el producto " + productName)
                .locatedBy(String.format("//li[contains(@class, 'product') and .//h2[contains(@class, 'woocommerce-loop-product__title') and text()='%s']]//a[contains(@class, 'add_to_cart_button')]", productName));
        // <<< ESTE LOCALIZADOR TAMBIEN DEBE SER AJUSTADO SI LOS ANTERIORES CAMBIAN
    }

} 