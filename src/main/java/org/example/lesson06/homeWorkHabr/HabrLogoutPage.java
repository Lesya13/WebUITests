package org.example.lesson06.homeWorkHabr;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HabrLogoutPage extends HabrBasePage {
    public HabrLogoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = userIconXpathLocator)
    public WebElement userIcon;

    @FindBy(xpath = logoutButtonXpathLocator)
    public WebElement logoutButton;

    @Step("Клик на кнопку Выход")
    public void clickOnLogoutButton () {
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(HabrLogoutPage.userIconXpathLocator)));
        userIcon.click();
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(HabrLogoutPage.logoutButtonXpathLocator)));
        logoutButton.click();
    }

    public static final String  userIconXpathLocator = "//div[@class='tm-entity-image']";
    public static final String  logoutButtonXpathLocator = "//span[contains(text(),'Выход')]";
}
