package com.reto_tecnico.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import com.reto_tecnico.tasks.NavigateToHomePage;
import com.reto_tecnico.tasks.SelectCategory;
import com.reto_tecnico.tasks.AddSelectedProductsToCart;
import com.reto_tecnico.questions.CartItemCount;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.equalTo;

public class ShoppingStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    @Given("that the user is on the home page")
    public void thatTheUserIsOnTheHomePage() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("user").attemptsTo(
                NavigateToHomePage.usingDefaultBrowser()
        );
    }

    @When("the user navigates to the {string} category page")
    public void theUserNavigatesToTheCategoryPage(String category) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectCategory.called(category)
        );
    }

    @When("the user adds the first two visible products to the shopping cart")
    public void theUserAddsTheFirstTwoVisibleProductsToTheShoppingCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddSelectedProductsToCart.theFirstTwo()
        );
    }

    @Then("the shopping cart should show {int} items")
    public void theShoppingCartShouldShowItems(int numberOfItems) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CartItemCount.displayed(), equalTo(numberOfItems))
        );
    }
} 