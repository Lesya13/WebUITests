package org.example.lesson08.homeWork;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinitionsForHabr {
    @After
    public void after() {
        Selenide.closeWebDriver();
    }
}
