package org.example.lesson06.homeWorkHabr;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HabrLoginPage extends HabrBasePage {
    public HabrLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement inputHabrLogin;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputHabrPassword;

    @FindBy(xpath = "//div/button[@name='go']")
    public WebElement loginHabrButton;

    @Step("Заполнить поле логина")
    public HabrLoginPage fillInputHabrLogin(String habrLogin) {
        inputHabrLogin.sendKeys(habrLogin);
        return this;
    }

    @Step("Заполнить поле пароля")
    public HabrLoginPage fillInputHabrPassword(String habrPassword) {
        inputHabrPassword.sendKeys(habrPassword);
        return this;
    }

    @Step("Клик на кнопку логина")
    public MainHabrPage clickLoginButton() {
        loginHabrButton.click();
        return new MainHabrPage(driver); //доделать мэйн страницу
    }
}
