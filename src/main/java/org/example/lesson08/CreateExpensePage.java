package org.example.lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreateExpensePage {

    private SelenideElement expenseRequestName = $(By.name("crm_expense_request[description]"));

    @Step("Заполнить имя")
    public CreateExpensePage fillName(String name) {
        expenseRequestName.sendKeys(name);
        return this;
    }

    private SelenideElement businessUnitSelect = $(By.name("crm_expense_request[businessUnit]"));

    @Step("Выбрать бизнес юнит")
    public CreateExpensePage selectBusinessUnit(String businessUnit) {
        businessUnitSelect.selectOptionContainingText(businessUnit);
        return this;
    }

    private SelenideElement selectExpenditure = $(By.name("crm_expense_request[expenditure]"));

    @Step("Заполнить Expenditure")
    public CreateExpensePage selectExpenditure(String expenditure) {
        selectExpenditure.selectOptionContainingText(expenditure);
        return this;
    }

    private SelenideElement selectCurrency = $(By.name("crm_expense_request[currency]"));

    @Step("Выбрать валюту")
    public CreateExpensePage selectCurrency(String currency) {
        selectCurrency.selectOptionContainingText(currency);
        return this;
    }

    private SelenideElement sumPlan = $(By.name("crm_expense_request[sumPlan]"));

    @Step("Выбрать сумму")
    public CreateExpensePage fillSumPlan(String sum) {
        sumPlan.sendKeys(sum);
        return this;
    }

    private SelenideElement plannedDate = $(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan')]"));

    private List<SelenideElement> dayInCalendar = $$(By.xpath("//td[@data-handler='selectDay']/a"));

    @Step("Выбрать дату")
    public CreateExpensePage selectDatePlan(String dayOfMonth) {
        plannedDate.click();
        dayInCalendar.stream()
                .filter(element -> element.getText().equals(dayOfMonth))
                .findFirst().get().click();
        return this;
    }

    public SelenideElement saveAndCloseButton = $(By.xpath(saveAndCloseButtonXpathLocator));

    public SelenideElement requestSavedSuccessfullyElement = $(By.xpath(requestSavedSuccessfullyElementXpathLocator));

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";
    public static final String requestSavedSuccessfullyElementXpathLocator = "//*[text()='Заявка на расход сохранена']";
}
