package org.example.lesson06.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CounterpartiesRequestPage extends BaseCrmView {
    public CounterpartiesRequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createCounterpartiesXpathLocator)
    public WebElement createCounterpartiesButton;

    public CreateCounterpartiesPage createCounterparties() {
        createCounterpartiesButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CreateCounterpartiesPage.saveAndCloseButtonXpathLocator)));
        return new CreateCounterpartiesPage(driver);
    }

    public static final String createCounterpartiesXpathLocator = "//div/a[@class='btn back icons-holder-text ']";
}
