package org.example.lesson06.homeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateCounterpartiesPage extends BaseCrmView {

    public CreateCounterpartiesPage(WebDriver driver) {
        super(driver);
    }
    //wait
    @FindBy(xpath = "//div/input[@name='crm_contact[lastName]']")
    public WebElement lastName;

    public CreateCounterpartiesPage fillLastName(String inputLastName) {
        lastName.sendKeys(inputLastName);
        return this;
    }

    @FindBy(xpath = "//div/input[@name='crm_contact[firstName]']")
    public WebElement firstName;

    public CreateCounterpartiesPage fillFirstName(String inputFirstName) {
        lastName.sendKeys(inputFirstName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement fillOrganizationName;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement organizationNameSelect;

    public CreateCounterpartiesPage selectOrganizationName(String organizationName) {
        new Select(organizationNameSelect).selectByVisibleText(organizationName);
        return this;
    }
    //wait

    @FindBy(xpath = "//input[@name='crm_contact[jobTitle]']")
    public WebElement jobTitle;

    public CreateCounterpartiesPage fillJobTitle(String jobName) {
        jobTitle.sendKeys(jobName);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//div/button[contains(text(),'Сохранить и закрыть')]";

    @FindBy(xpath = requestSavedSuccessfullyContactFaceXpathLocator)
    public WebElement requestSavedSuccessfullyContactFace;

    public static final String requestSavedSuccessfullyContactFaceXpathLocator = "//*[text()='Контактное лицо сохранено']";

}
