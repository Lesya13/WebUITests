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
 //       this.driver = driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
 //       WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
}
