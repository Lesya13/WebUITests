package org.example.lesson06.homeWork;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("Создание нового проекта")
public class CreateProjectPageTest extends BaseCrmTest {
    @Test
    @Description("Тест логина и создание нового проекта")
    void loginInCrmWithCounterpartiesPageObjectTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/");
        new LoginCrmPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationCrmMenu.openNavigationCrmMenuItem();

        new CrmProjectSubMenu(driver)
                .tryToGoToMyProjectPage();
        new CrmProjectSubMenu(driver)
                .goToProjectsRequestsPage();

        new CreateProjectPage(driver)
                .fillProjectNameWithData("Queen of the South season 2")
                .selectOfOrganizationName("Bins-Haley")
                .selectCrmBusinessUnit("Research & Development")
                .selectCrmCurator("Applanatest Applanatest Applanatest")
                .selectCrmProjectSupervisor("Applanatest Applanatest Applanatest")
                .selectCrmProjectManager("Applanatest Applanatest Applanatest")
                .saveAndCloseButton.click();

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));
        assertThat(new CreateProjectPage(driver).requestSavedSuccessfullyProject, isDisplayed());
    }
}
