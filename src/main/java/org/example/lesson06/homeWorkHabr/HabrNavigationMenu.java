package org.example.lesson06.homeWorkHabr;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HabrNavigationMenu extends HabrBasePage {
    public HabrNavigationMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".tm-header-user-menu__icon_search")
    public WebElement findFirstUserIcon;

    @FindBy(css = ".tm-dropdown__head > .tm-svg-img > use")
    public WebElement findSecondUserIcon;

    @FindBy(xpath = "//a[@class='tm-user-menu__auth-button']")
    public WebElement findAndClickOnButtonInto;

    @Step("Клик на иконку пользователя")
    public void clickOnTheButtonInto () throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(findFirstUserIcon)
                .click().moveToElement(findSecondUserIcon)
                .release()
                .build()
                .perform();
        findAndClickOnButtonInto.click();
    }
}
