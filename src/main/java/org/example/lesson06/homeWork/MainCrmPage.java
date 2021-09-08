package org.example.lesson06.homeWork;

import org.openqa.selenium.WebDriver;

public class MainCrmPage extends BaseCrmView {
    public NavigationCrmMenu navigationCrmMenu;

    public MainCrmPage(WebDriver driver) {
        super(driver);
        navigationCrmMenu = new NavigationCrmMenu(driver);
    }
}
