package org.example.lesson05.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson03.homeWorkProject01.AddBookmark;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class AddBookmarkTest {

    static WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, 5);
        loginToHabr();
    }

    @Test
    void checkPageOfCompanyMailGroupRu() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Разработка')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Разработка')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span/a[contains(text(),'Компании')]")));
        driver.findElement(By.xpath("//span/a[contains(text(),'Компании')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Mail.ru Group")));
        assertThat(driver.findElement(By.linkText("Mail.ru Group"))
                .getCssValue("color"), is("rgba(51, 51, 51, 1)"));
    }

    @Test
    void checkOutFromAccount() throws InterruptedException {

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tm-header-user-menu__item tm-header-user-menu__user_desktop']")));
        driver.findElement(By.xpath("//div[@class='tm-header-user-menu__item tm-header-user-menu__user_desktop']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Выход')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Выход')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tm-header-user-menu__item tm-header-user-menu__user_desktop']")));
        driver.findElement(By.xpath("//div[@class='tm-header-user-menu__item tm-header-user-menu__user_desktop']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='tm-user-menu__auth-button']")));
        assertThat(driver.findElement(By.xpath("//div/a[contains(text(), 'Как стать автором')]")), hasText("КАК СТАТЬ АВТОРОМ"));

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public static void loginToHabr () {
        driver.get("https://habr.com/ru/all/");
        WebElement element = driver.findElement(By.cssSelector(".tm-header-user-menu__icon_search"));
        WebElement element1 = driver.findElement(By.cssSelector(".tm-dropdown__head > .tm-svg-img > use"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().moveToElement(element1).release().build().perform();

        driver.findElement(By.linkText("Войти")).click();

        driver.findElement(By.xpath("//input[@name='email']"))
                .sendKeys("olesia.geekbrains@yandex.ru");
        driver.findElement(By.xpath("//input[@name='password']"))
                .sendKeys("geekBrains13@");
        driver.findElement(By.xpath("//div/button[@name='go']")).click();
    }
}
