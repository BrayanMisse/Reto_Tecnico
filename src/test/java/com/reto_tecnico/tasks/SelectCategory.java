package com.reto_tecnico.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static com.reto_tecnico.userinterfaces.HomePageElements.CATEGORY_LINK;

public class SelectCategory implements Task {

    private final String categoryName;

    public SelectCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public static SelectCategory called(String categoryName) {
        return new SelectCategory(categoryName);
    }

    @Override
    @Step("{0} selects the category called {1}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CATEGORY_LINK.of(categoryName))
        );
    }
} 