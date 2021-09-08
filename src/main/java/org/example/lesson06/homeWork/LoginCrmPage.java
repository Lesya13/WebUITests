package org.example.lesson06.homeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginCrmPage extends BaseCrmView {

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    public LoginCrmPage(WebDriver driver) {
        super(driver);
    }

    public LoginCrmPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginCrmPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainCrmPage clickLoginButton() {
        loginButton.click();
        return new MainCrmPage(driver);
    }
}
