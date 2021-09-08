package org.example.lesson06.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CounterpartiesSubMenu extends BaseCrmView {

    public CounterpartiesSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a/span[contains(text(),'Контрагенты')]")
    public WebElement counterpartiesRequestsMenuItem;

    @FindBy(xpath = "//a/span[contains(text(),'Контактные лица')]")
    public WebElement contactFacesRequestsMenuItem;

    public void goToCounterpartiesRequestsPage() {
        counterpartiesRequestsMenuItem.click();
        contactFacesRequestsMenuItem.click();

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(CounterpartiesSubMenu.loader)));
        webDriverWait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.xpath(CounterpartiesSubMenu.loader)));

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(CounterpartiesRequestPage.createCounterpartiesXpathLocator)));
    }

    public static final String loader = "//div[@class='loader-mask shown']";
}
