package org.example.lesson08.homeWork;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HabrLogoutSteps {

    @Given("I fill login and password")
    public void iFillLoginAndPassword() {
        new HabrLoginPage().login("olesia.geekbrains@yandex.ru", "geekBrains13@");
    }

    @When("I click the develop")
    public void iClickTheDevelop() {
        new HabrNavigationMenu().clickOnTheIconDeveloper();
    }

    @And("I click on companies")
    public void iClickOnCompanies() {
        new HabrNavigationMenu().clickOnTheIconCompanies();
    }

    @And("I click on company name by Mail.ru")
    public void iClickOnCompanyNameByMailRu() {
        new HabrNavigationMenu().clickOnTheCompanyByNameMail();
    }

    @And("I click on news")
    public void iClickOnNews() {
        new HabrNavigationMenu().clickOnNews();
    }

    @And("I click on the bookmark")
    public void iClickOnTheBookmark() {
        new HabrNavigationMenu().clickOnBookmark();
    }

    @And("I click on the user icon")
    public void iClickOnTheUserIcon() {
        new HabrNavigationMenu().clickOnUserButtonIcon();
    }

    @And("I click on the user bookmark")
    public void iClickOnTheUserBookmark() {
        new HabrNavigationMenu().clickOnElementBookmark("Закладки");
    }

    @Then("Success logout from Habr")
    public void successLogoutFromHabr() {
        new HabrLogoutPage().clickOnLogoutButton("Выход");
    }
}
