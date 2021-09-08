package org.example.lesson06.homeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCrmView {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BaseCrmView(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}
