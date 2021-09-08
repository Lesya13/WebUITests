package org.example.lesson06.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateCounterpartiesPage extends BaseCrmView {

    public CreateCounterpartiesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement lastName;

    public CreateCounterpartiesPage fillLastName(String inputLastName) {
        lastName.sendKeys(inputLastName);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;

    public CreateCounterpartiesPage fillFirstName(String inputFirstName) {
        firstName.sendKeys(inputFirstName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement fillOrganizationName;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement organizationNameSelect;

    @FindBy(xpath = "//div[@class='select2-result-label']")
    public WebElement chosenOrganizationClickable;

    public CreateCounterpartiesPage selectOrganizationName(String organizationName) {
        fillOrganizationName.click();
        webDriverWait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@id='select2-drop']//input")));
        organizationNameSelect.sendKeys(organizationName);
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        chosenOrganizationClickable.click();
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[@class='select2-chosen']")));
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;

    public CreateCounterpartiesPage fillJobTitle(String jobName) {
        jobTitle.sendKeys(jobName);
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("select2-drop-mask")));
        webDriverWait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.id("select2-drop-mask")));
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[@class='btn btn-success action-button']";

    @FindBy(xpath = requestSavedSuccessfullyContactFaceXpathLocator)
    public WebElement requestSavedSuccessfullyContactFace;

    public static final String requestSavedSuccessfullyContactFaceXpathLocator = "//*[text()='Контактное лицо сохранено']";

}
