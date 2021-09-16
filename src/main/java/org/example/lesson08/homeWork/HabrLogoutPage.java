package org.example.lesson08.homeWork;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class HabrLogoutPage {

    private List<SelenideElement> logoutButton = $$(By.xpath(logoutButtonXpathLocator));

    @Step("Клик на кнопку Выход")
    public HabrLogoutPage clickOnLogoutButton (String logout) {
        logoutButton.stream()
                .filter(element -> element.getText().equals(logout))
                .findFirst().get().click();
        return this;
    }

    public static final String  logoutButtonXpathLocator = "//div[@class='tm-user-menu__menu_bottom']";
}
