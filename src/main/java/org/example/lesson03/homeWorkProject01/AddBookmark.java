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

public class AddBookmark {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToHabr();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Разработка')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Разработка')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span/a[contains(text(),'Компании')]")));
        driver.findElement(By.xpath("//span/a[contains(text(),'Компании')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Mail.ru Group")));
        driver.findElement(By.linkText("Mail.ru Group")).click();
        //scroll
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span/a[contains(text(),'Новости')]")).click();

        //scroll
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//article[1]//button[contains(@title,'заклад')]")));
        driver.findElement(By.xpath("//article[1]//button[contains(@title,'заклад')]")).click();
        driver.findElement(By.xpath("//div[@class='tm-header-user-menu__item tm-header-user-menu__user_desktop']")).click();
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