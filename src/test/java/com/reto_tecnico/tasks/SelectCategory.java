package com.reto_tecnico.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectCategory implements Task {

    private final String categoryName;

    private static final Target CATEGORY_LINK = Target.the("category link").locatedBy("//a[contains(text(), \"{0}\")]");

    public SelectCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CATEGORY_LINK.of(categoryName))
        );
    }

    public static Performable called(String categoryName) {
        return instrumented(SelectCategory.class, categoryName);
    }
} 