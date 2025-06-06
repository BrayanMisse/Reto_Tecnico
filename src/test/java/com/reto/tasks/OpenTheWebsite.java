package com.reto.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheWebsite implements Task {

    private String url;

    public OpenTheWebsite(String url) {
        this.url = url;
    }

    public static OpenTheWebsite at(String url) {
        return instrumented(OpenTheWebsite.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
} 