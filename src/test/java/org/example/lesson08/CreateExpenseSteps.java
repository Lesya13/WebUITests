package org.example.lesson08;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateExpenseSteps {
    @Given("I am authorized")
    public void iAmAuthorized() {
        new LoginPage().login("applanatest1", "Student2020!");
    }

    @Given("I am at expense page")
    public void iAmAtExpensePage() {
        new MainPage().navigationMenu.openNavigationMenuItem("Расходы");
        new ExpensesSubMenu().goToExpensesRequestsPage().createExpense();
    }

    @When("I fill name field")
    public void iFillNameField() {
        new CreateExpensePage().fillName("test");
    }

    @And("I select business unit")
    public void iSelectBusinessUnit() {
        new CreateExpensePage().selectBusinessUnit("Research & Development");
    }

    @And("I select expenditure")
    public void iSelectExpenditure() {
        new CreateExpensePage().selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры");
    }

    @And("I select currency")
    public void iSelectCurrency() {
        new CreateExpensePage().selectCurrency("Доллар США");
    }

    @And("I fill sum plan")
    public void iFillSumPlan() {
        new CreateExpensePage().fillSumPlan("100");
    }

    @And("I select date plan")
    public void iSelectDatePlan() {
        new CreateExpensePage().selectDatePlan("20");
    }

    @And("I click save and close button")
    public void iClickSaveAndCloseButton() {
        new CreateExpensePage().saveAndCloseButton.click();
    }

    @Then("Success message is visible")
    public void successMessageIsVisible() {
        new CreateExpensePage().requestSavedSuccessfullyElement.shouldBe(Condition.visible);
    }

    @When("I fill {string} field")
    public void iFillNameField(String name) {
        new CreateExpensePage().fillName(name);
    }
}
