package org.example.lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {


    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //общий метод для входа
    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputLogin.sendKeys(password);
        loginButton.click();
    }

    //ниже 3 отдельных метода для входа
    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }
}
