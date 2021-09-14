package org.example.lesson06.homeWork;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseCrmView {
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = elementOfInputNameOfProjectXpathLocator)
    public WebElement nameOfProject;

    public CreateProjectPage fillProjectNameWithData(String projectName) {
        nameOfProject.click();
        nameOfProject.sendKeys(projectName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement fillOrganizationName;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement organizationNameSelect;

    @FindBy(xpath = "//div[@class='select2-result-label']")
    public WebElement chosenOrganizationClickable;

    @Step("Выбрать организацию")
    public CreateProjectPage selectOfOrganizationName(String organizationName) {
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

    @FindBy(xpath = "//select[@name='crm_project[businessUnit]']")
    public WebElement crmBusinessUnitSelect;

    @Step("Выбрать бизнес юнит")
    public CreateProjectPage selectCrmBusinessUnit(String crmBusinessUnit) {
        new Select(crmBusinessUnitSelect).selectByVisibleText(crmBusinessUnit);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[curator]']")
    public WebElement curatorCrmSelect;

    @Step("Выбрать куратора")
    public CreateProjectPage selectCrmCurator(String crmCurator) {
        new Select(curatorCrmSelect).selectByVisibleText(crmCurator);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[rp]']")
    public WebElement crmProjectSupervisorSelect;

    @Step("Выбрать руководителя проекта")
    public CreateProjectPage selectCrmProjectSupervisor(String crmProjectSupervisor) {
        new Select(crmProjectSupervisorSelect).selectByVisibleText(crmProjectSupervisor);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[manager]']")
    public WebElement crmProjectManagerSelect;

    @Step("Выбрать руководителя проекта")
    public CreateProjectPage selectCrmProjectManager(String crmProjectManager) {
        new Select(crmProjectManagerSelect).selectByVisibleText(crmProjectManager);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    @FindBy(xpath = requestSavedSuccessfullyProjectXpathLocator)
    public WebElement requestSavedSuccessfullyProject;

    public static final String requestSavedSuccessfullyProjectXpathLocator = "//*[text()='Проект сохранен']";
    public static final String elementOfInputNameOfProjectXpathLocator = "//input[@name='crm_project[name]']";
    public static final String saveAndCloseButtonXpathLocator = "//button[@class='btn btn-success action-button']";
}