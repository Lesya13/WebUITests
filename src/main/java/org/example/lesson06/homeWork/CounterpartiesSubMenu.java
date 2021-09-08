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

    @FindBy(xpath = toCreateContactFaceButtonXpathLocator)
    public WebElement toCreateContactFaceButton;

    public void goToCounterpartiesRequestsPage() throws InterruptedException {
        counterpartiesRequestsMenuItem.click();
        contactFacesRequestsMenuItem.click();
        webDriverWait.until(ExpectedConditions
                .elementToBeClickable(By.xpath(CounterpartiesSubMenu.toCreateContactFaceButtonXpathLocator)));
        Thread.sleep(10000);
        toCreateContactFaceButton.click();
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(CounterpartiesRequestPage.createCounterpartiesXpathLocator)));
    }

    public static final String toCreateContactFaceButtonXpathLocator = "//a[@title='Создать контактное лицо']";
}
