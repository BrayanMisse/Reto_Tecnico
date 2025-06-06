package com.reto_tecnico.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
// Importaciones de Screenplay (serán eliminadas/reemplazadas para los pasos de POM)
// import net.serenitybdd.screenplay.Actor;
// import net.serenitybdd.screenplay.actors.OnStage;
// import net.serenitybdd.screenplay.actors.OnlineCast;
// import com.reto_tecnico.tasks.NavigateToHomePage;
// import com.reto_tecnico.tasks.SelectCategory;
// import com.reto_tecnico.tasks.AddSelectedProductsToCart;
// import com.reto_tecnico.questions.CartItemCount;

// Importaciones para POM
import com.reto_tecnico.pages.HomePage; // Importar HomePage Page Object
import com.reto_tecnico.pages.CategoryPage; // Importar CategoryPage Page Object
import net.thucydides.core.annotations.Steps;

// Importaciones para aserciones
import static org.junit.Assert.assertThat; // Importar assertThat
import static org.hamcrest.Matchers.equalTo; // Importar equalTo

public class ShoppingStepDefinitions {

    @Steps
    HomePage homePage; // Instanciar el HomePage Page Object

    @Steps
    CategoryPage categoryPage; // Instanciar el CategoryPage Page Object

    @Given("that the user is on the home page")
    public void thatTheUserIsOnTheHomePage() {
        // Lógica para navegar a la página principal usando POM
        homePage.open();
    }

    @When("the user navigates to the {string} category page")
    public void theUserNavigatesToTheCategoryPage(String category) {
        // Implementar lógica con POM para navegar a la categoría
        homePage.navigateToCategory(category);
    }

    @When("the user adds the first two visible products to the shopping cart")
    public void theUserAddsTheFirstTwoVisibleProductsToTheShoppingCart() {
        // Implementar lógica con POM para añadir productos al carrito
        categoryPage.addFirstTwoProductsToCart();
    }

    @Then("the shopping cart should show {int} items")
    public void theShoppingCartShouldShowItems(int numberOfItems) {
        // Implementar lógica con POM para verificar el número de ítems
        assertThat(homePage.getCartItemCount(), equalTo(numberOfItems));
    }
} 