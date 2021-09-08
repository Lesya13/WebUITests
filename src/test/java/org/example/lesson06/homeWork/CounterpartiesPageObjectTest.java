package org.example.lesson06.homeWork;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CounterpartiesPageObjectTest extends BaseCrmTest {
    @Test
    void loginInCrmWithCounterpartiesPageObjectTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/");
        new LoginCrmPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationCrmMenu.openNavigationCrmMenuItem();

        new CounterpartiesSubMenu(driver).goToCounterpartiesRequestsPage();

        new CounterpartiesRequestPage(driver)
                .createCounterparties()
                .fillLastName("Snow")
                .fillFirstName("Jon")
                .selectOrganizationName("Bins-Haley")
                .fillJobTitle("The king of the North")
                .saveAndCloseButton.click();


        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));
        assertThat(new CreateCounterpartiesPage(driver).requestSavedSuccessfullyContactFace, isDisplayed());
    }
}
