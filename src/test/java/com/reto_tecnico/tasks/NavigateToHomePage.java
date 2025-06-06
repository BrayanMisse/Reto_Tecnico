package com.reto_tecnico.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToHomePage implements Task {

    private String url;

    public NavigateToHomePage(String url) {
        this.url = url;
    }

    public static NavigateToHomePage to(String url) {
        return new NavigateToHomePage(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
} 