package org.example.lesson06;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationMenu extends BaseView {
    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li")
    public List<WebElement> navigationMenuItems;

    @Step("Открыть навигационное меню")
    public void openNavigationMenuItem(String menuName) {
        Actions actions = new Actions(driver);
        //создали stream для доступа к элементам в navigationMenuItems
        actions.moveToElement(navigationMenuItems.stream()
                //отфильтровали с помощью filter, если у элемента текст соответствует тексту искомого элемента
                .filter(element -> element.getText().equals(menuName))
                .findFirst().get()).perform();
    }
}
