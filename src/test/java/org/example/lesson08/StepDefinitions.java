package org.example.lesson08;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefinitions {
    @After
    public void after() {
        Selenide.closeWebDriver();
    }
}
