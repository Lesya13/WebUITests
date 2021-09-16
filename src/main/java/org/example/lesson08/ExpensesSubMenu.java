package org.example.lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ExpensesSubMenu {

    private SelenideElement expensesRequestsMenuItem = $(By.xpath("//span[text()='Заявки на расходы']"));

    @Step("Перейти на страницу заявок на расходы")
    public ExpensesRequestsPage goToExpensesRequestsPage() {
        expensesRequestsMenuItem.click();
        return page(ExpensesRequestsPage.class);
    }
}
