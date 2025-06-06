package com.reto.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToCategory implements Task {

    private final Target categoryLink;
    private final String categoryName;

    public NavigateToCategory(Target categoryLink, String categoryName) {
        this.categoryLink = categoryLink;
        this.categoryName = categoryName;
    }

    public static NavigateToCategory called(String categoryName, Target categoryLink) {
        return instrumented(NavigateToCategory.class, categoryLink, categoryName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(categoryLink)
        );
    }
} 