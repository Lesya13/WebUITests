package org.example.lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        //блокировка всплывающихуведомлений или рекламы
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications")
                //google robot
                .addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot/html)");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        //вариант открытия браузера под максимальный размер экрана
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //вариант открытия браузера с определенным размером окна
        driver.manage().window().setSize(new Dimension(500, 500));
        Thread.sleep(5000);
        driver.quit();
    }
}
