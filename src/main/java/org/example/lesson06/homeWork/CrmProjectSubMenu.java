package org.example.lesson06.homeWork;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CrmProjectSubMenu extends BaseCrmView {

    public CrmProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = itemOfProjectsXpathLocator)
    public WebElement projectRequestsMenuItem;

    @Step("Попытка перейти на страницу мои проекты")
    public void tryToGoToMyProjectPage() {
        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath(CrmProjectSubMenu.itemOfProjectsXpathLocator));
        actions.moveToElement(projectMenuElement).perform();
    }

    @FindBy(linkText = "Мои проекты")
    public WebElement myProjectsMenuItem;

    @Step("Переход на страницу создания проекта")
    public void goToProjectsRequestsPage() throws InterruptedException {
        projectRequestsMenuItem.click();
        tryToGoToMyProjectPage();
        myProjectsMenuItem.click();
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(CrmProjectSubMenu.buttonOfCreatingProjectXpathLocator)));
        buttonOfCreateProject.click();
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(CreateProjectPage.elementOfInputNameOfProjectXpathLocator)));
    }

    @FindBy(xpath = buttonOfCreatingProjectXpathLocator)
    public WebElement buttonOfCreateProject;


    public static final String itemOfProjectsXpathLocator = "//span[text()='Проекты']/ancestor::a";
    public static final String buttonOfCreatingProjectXpathLocator = "//a[text()='Создать проект']";
}
