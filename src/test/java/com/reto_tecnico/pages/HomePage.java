package com.reto_tecnico.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://www.floristeriamundoflor.com/")
public class HomePage extends PageObject {

    // Localizador genérico para enlaces de categoría usando XPath con parametro
    private static final String CATEGORY_LINK = "//a[contains(text(),'{0}')]";

    // Localizador para el contador de ítems en el carrito
    private static final By CART_COUNT_LOCATOR = By.cssSelector(".cart-count"); // Asumiendo que el contador tiene esta clase CSS

    public CategoryPage navigateToCategory(String categoryName) {
        // Encontrar el enlace de la categoría y hacer clic
        find(String.format(CATEGORY_LINK, categoryName)).click();
        // Devolver la nueva página (página de categoría)
        return new CategoryPage();
    }

    public int getCartItemCount() {
        // Obtener el texto del contador del carrito y convertirlo a entero
        String countText = find(CART_COUNT_LOCATOR).getText();
        try {
            return Integer.parseInt(countText.trim());
        } catch (NumberFormatException e) {
            System.err.println("Could not parse cart count as integer: " + countText);
            return 0; // Devolver 0 o manejar el error según se necesite
        }
    }
} 