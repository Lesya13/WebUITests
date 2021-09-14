package org.example.lesson06.homeWork;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NavigationCrmMenu extends BaseCrmView {

    public NavigationCrmMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = itemOfCounterpartiesXpathLocator)
    public WebElement navigationCrmMenuItems;

    @Step("Открыть навигационное меню")
    public void openNavigationCrmMenuItem() {
        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath(NavigationCrmMenu.itemOfCounterpartiesXpathLocator));
        actions.moveToElement(projectMenuElement).perform();
    }

    public static final String  itemOfCounterpartiesXpathLocator = "//a/span[contains(text(),'Контрагенты')]";
}
