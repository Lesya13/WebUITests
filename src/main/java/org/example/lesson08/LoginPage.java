package org.example.lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private SelenideElement inputLogin = $(By.id("prependedInput"));

    private SelenideElement inputPassword = $(By.id("prependedInput2"));

    private SelenideElement loginButton = $(By.xpath("//button"));

    @Step("Заполнить поле логина")
    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку логина")
    public MainPage clickLoginButton() {
        loginButton.click();
        return page(MainPage.class);
    }

    public MainPage login(String login, String password) {
        open("https://crm.geekbrains.space/");
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        loginButton.click();
        return page(MainPage.class);
    }
}