package org.example.lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ExpensesRequestsPage {

    private SelenideElement createExpenseButton = $(By.xpath(createExpenseXpathLocator));

    @Step("Создать заявку на расход")
    public CreateExpensePage createExpense() {
        createExpenseButton.click();
        return page(CreateExpensePage.class);
    }

    public static final String createExpenseXpathLocator = "//a[text()='Создать заявку на расход']";
}
