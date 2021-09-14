package org.example.lesson06.homeWorkHabr;

import org.openqa.selenium.WebDriver;

public class MainHabrPage extends HabrBasePage {
    public HabrNavigationMenu habrNavigationMenu;

    public MainHabrPage(WebDriver driver) {
        super(driver);
        habrNavigationMenu = new HabrNavigationMenu(driver);
    }
}
