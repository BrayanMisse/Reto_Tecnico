package com.reto_tecnico.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToHomePage implements Task {

    private static final String URL = "https://www.floristeriamundoflor.com/";

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL)
        );
    }

    public static Performable usingDefaultBrowser() {
        return instrumented(NavigateToHomePage.class);
    }
} 