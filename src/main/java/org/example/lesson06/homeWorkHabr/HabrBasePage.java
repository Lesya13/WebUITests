package org.example.lesson06.homeWorkHabr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HabrBasePage {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public HabrBasePage(WebDriver driver) {
        this.driver = driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        this.driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(driver, this);
    }
}
