package org.example.lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseView {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 10);
        //передаем драйвер и текущую страницу
        PageFactory.initElements(driver, this);
    }
}
