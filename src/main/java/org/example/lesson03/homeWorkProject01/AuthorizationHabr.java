package org.example.lesson03.homeWorkProject01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationHabr {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToHabr();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tm-entity-image']")));
        driver.findElement(By.xpath("//div[@class='tm-entity-image']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Выход')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Выход')]")).click();

        driver.quit();

    }

    public static void loginToHabr () {
        driver.get("https://habr.com/ru/all/");
        WebElement element = driver.findElement(By.cssSelector(".tm-header-user-menu__icon_search"));
        WebElement element1 = driver.findElement(By.cssSelector(".tm-dropdown__head > .tm-svg-img > use"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().moveToElement(element1).release().build().perform();

        driver.findElement(By.linkText("Войти")).click();

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("olesia.geekbrains@yandex.ru");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("geekBrains13@");
        driver.findElement(By.xpath("//div/button[@name='go']")).click();
    }

}
