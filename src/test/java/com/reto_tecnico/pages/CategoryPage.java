package com.reto_tecnico.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class CategoryPage extends PageObject {

    // Localizador para todos los ítems de producto en la página de categoría
    @FindBy(css = ".product-item") // Asumiendo que los ítems de producto tienen esta clase CSS
    public List<WebElementFacade> productItems;

    // Localizador relativo al ítem de producto para el botón de añadir al carrito
    private static final By ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR = By.cssSelector(".add-to-cart-button"); // Asumiendo que este selector CSS está dentro del ítem

    public void addFirstTwoProductsToCart() {
        // Esperar a que al menos dos ítems de producto estén visibles (opcional pero recomendado)
        // waitFor(ExpectedConditions.numberOfElementsToBeMoreThan(ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR, 1));

        // Asegurarse de que hay al menos dos productos antes de intentar hacer clic
        if (productItems.size() >= 2) {
            // Hacer clic en el botón "Agregar al carrito" para los dos primeros productos
            productItems.get(0).find(ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR).click();
            productItems.get(1).find(ADD_TO_CART_BUTTON_INSIDE_ITEM_LOCATOR).click();
        } else {
            System.out.println("Warning: Less than two products found on the category page.");
            // Dependiendo de los requisitos, puedes lanzar una excepción aquí
        }
    }

    // Aquí se agregarán otros métodos para interactuar con la página de categoría si es necesario
} 