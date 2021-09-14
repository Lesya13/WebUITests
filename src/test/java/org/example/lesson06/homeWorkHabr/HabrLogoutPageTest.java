package org.example.lesson06.homeWorkHabr;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class HabrLogoutPageTest extends HabrBaseTest{
    @Test
    @Description("Тест на вход и выход")
    void loginInHabrWithHabrLogoutPageTest() throws InterruptedException {
        driver.get("https://habr.com/ru");
        new HabrNavigationMenu(driver).clickOnTheButtonInto();

        new HabrLoginPage(driver)
                .fillInputHabrLogin("")
                .fillInputHabrPassword("")
                .clickLoginButton();

        new HabrLogoutPage(driver)
                .clickOnLogoutButton();
    }
}
