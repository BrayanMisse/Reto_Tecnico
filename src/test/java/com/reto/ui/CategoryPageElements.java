package com.reto.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CategoryPageElements {

    // Target para el enlace de la categoría "Amor"
    // !!! ATENCION: Este localizador es un EJEMPLO. Debes verificarlo y ajustarlo si es necesario
    // inspeccionando la página web: https://www.floristeriamundoflor.com/
    public static final Target CATEGORY_LINK = Target.the("enlace a la categoría Amor")
            .locatedBy("//a[contains(@href, 'product-category/amor')]");

    // Este Target específico puede ser útil si hay casos especiales, pero usaremos el método general.
    public static final Target CATEGORY_LINK_AMOR = Target.the("enlace a la categoría Amor")
            .locatedBy("//a[contains(@href, 'product-category/amor')]");

    // Método para obtener el Target del enlace de una categoría dado su nombre.
    // Asume que el nombre de la categoría aparece en el href en formato slug (minúsculas, espacios por guiones).
    public static Target linkForCategory(String categoryName) {
        String categorySlug = categoryName.toLowerCase().replace(" ", "-");
        // Busca un enlace que contenga en su href la ruta de la categoría.
        // Podrías necesitar ajustar este localizador si la estructura de URLs o texto es diferente.
        return Target.the("enlace a la categoría " + categoryName)
                .locatedBy(String.format("//a[contains(@href, 'product-category/%s') or contains(text(), '%s') ]", categorySlug, categoryName));
    }

} 