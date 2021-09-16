package org.example.lesson08.homeWork;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class HabrLoginPage {

    private SelenideElement inputHabrLogin = $(By.xpath("//input[@name='email']"));

    private SelenideElement inputHabrPassword = $(By.xpath("//input[@name='password']"));

    private SelenideElement loginHabrButton = $(By.xpath("//button[@class='button button_wide button_primary']"));

    @Step("Заполнить логин, пароль и нажать кнопку входа")
    public MainHabrPage login(String login, String password) {
        open("https://account.habr.com/login/?consumer=habr&state=f8d7f1cefe5eea59be0354032ea7d020");
        inputHabrLogin.sendKeys(login);
        inputHabrPassword.sendKeys(password);
        loginHabrButton.click();
        return page(MainHabrPage.class);
    }
}
