package org.example.lesson08.homeWork;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HabrNavigationMenu {

    private SelenideElement findIconDeveloper = $(By.xpath("//a[contains(text(),'Разработка')]"));

    @Step("Клик на Разработка")
    public void clickOnTheIconDeveloper () {
        findIconDeveloper.click();
    }

    private SelenideElement findIconCompanies = $(By.xpath("//span/a[contains(text(),'Компании')]"));

    @Step("Клик на Компании")
    public void clickOnTheIconCompanies () {
        findIconCompanies.click();
    }

    private SelenideElement findCompanyNameByMailRu = $(By.linkText("Mail.ru Group"));

    @Step("Клик на компанию Mail.ru")
    public void clickOnTheCompanyByNameMail () {
        findCompanyNameByMailRu.click();
    }

    private SelenideElement findNews = $(By.xpath("//span/a[contains(text(),'Новости')]"));

    @Step("Клик на новости")
    public void clickOnNews () {
        findNews.click();
    }

    private SelenideElement findBookmark = $(By.xpath("//article[1]//button[contains(@title,'заклад')]"));

    @Step("Клик на заметку")
    public void clickOnBookmark () {
        findBookmark.click();
    }

    private SelenideElement findUserIcon = $(By.xpath("//button[@data-test-id='menu-toggle-user']"));

    @Step("Клик на иконку юзера")
    public void clickOnUserButtonIcon () {
        findUserIcon.click();
    }

    private List<SelenideElement> findElementBookmark = $$(By.xpath("//a[@class='tm-user-menu__menu-link']"));

    @Step("Клик на закладки")
    public HabrNavigationMenu clickOnElementBookmark (String bookmarks) {
        findElementBookmark.stream()
                .filter(element -> element.getText().equals(bookmarks))
                .findFirst().get().click();
        return this;
    }
}
