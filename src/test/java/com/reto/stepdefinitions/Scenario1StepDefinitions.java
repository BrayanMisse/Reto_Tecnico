package com.reto.stepdefinitions;

import com.reto.tasks.AddProductToCart;
import com.reto.tasks.NavigateToCategory;
import com.reto.tasks.OpenTheWebsite;
import com.reto.tasks.RemoveProductFromCart;
import com.reto.actors.Buyer;
import com.reto.questions.NumberOfItemsInCart;
import com.reto.questions.ProductInCart;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.assertj.core.api.Assertions.assertThat;

public class Scenario1StepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that a buyer wants to add products to their cart")
    public void thatABuyerWantsToAddProductsToTheirCart() {
        theActorCalled("Pepito").whoCan(net.serenitybdd.screenplay.abilities.BrowseTheWeb.withAnOrdinaryBrowser()); // Usar un navegador real para interacciones UI
    }

    @Given("that a buyer wants to manage their cart")
    public void thatABuyerWantsToManageTheirCart() {
        theActorCalled("Pepito").whoCan(net.serenitybdd.screenplay.abilities.BrowseTheWeb.withAnOrdinaryBrowser()); // Usar un navegador real para interacciones UI
    }

    @When("the buyer opens the website at {string}")
    public void theBuyerOpensTheWebsiteAt(String url) {
        theActorCalled("Pepito").attemptsTo(
                OpenTheWebsite.at(url)
        );
    }

    @When("navigates to the {string} category")
    public void navigatesToTheCategory(String categoryName) {
        theActorCalled("Pepito").attemptsTo(
                NavigateToCategory.called(categoryName, com.reto.ui.CategoryPageElements.linkForCategory(categoryName)) // Usar el nuevo método genérico
        );
    }

    @When("adds product {string} to the cart")
    public void addsProductToTheCart(String productName) {
        theActorCalled("Pepito").attemptsTo(
                AddProductToCart.called(productName)
        );
    }

    @When("the buyer removes product {string} from the cart")
    public void theBuyerRemovesProductFromTheCart(String productName) {
        theActorCalled("Pepito").attemptsTo(
                RemoveProductFromCart.called(productName)
        );
    }

    @Then("the cart should contain {int} items")
    public void theCartShouldContainItems(int expectedItemCount) {
        theActorCalled("Pepito").should(
                assertThat(NumberOfItemsInCart.displayed().answeredBy(theActorCalled("Pepito")))
                        .isEqualTo(expectedItemCount)
        );
    }

    @Then("the cart should contain {string}")
    public void theCartShouldContain(String productName) {
        theActorCalled("Pepito").should(
                assertThat(ProductInCart.called(productName).answeredBy(theActorCalled("Pepito")))
                        .isTrue()
        );
    }

    @Then("the cart should not contain {string}")
    public void theCartShouldNotContain(String productName) {
        theActorCalled("Pepito").should(
                assertThat(ProductInCart.called(productName).answeredBy(theActorCalled("Pepito")))
                        .isFalse()
        );
    }
} 