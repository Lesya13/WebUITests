package org.example.lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class CreateCrmProjectExample {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToCrm();

        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("crm_project[students_02/09/21]");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Bins-Haley");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = Collections.singletonList(driver.findElement(By.xpath("//div[@class='select2-result-label']")));
        organizationVars.get(0).click();

        driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")).sendKeys("Research & Development");

        driver.findElement(By.xpath("//select[@name='crm_project[curator]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[curator]']")).sendKeys("Applanatest Applanatest Applanatest");

        driver.findElement(By.xpath("//select[@name='crm_project[rp]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[rp]']")).sendKeys("Applanatest Applanatest Applanatest");

        driver.findElement(By.xpath("//select[@name='crm_project[manager]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[manager]']")).sendKeys("Applanatest Applanatest Applanatest");

//      webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]")));
//      webDriverWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]")), "123test"));
        Thread.sleep(1000); //заменить на нормальное ожидание
        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select2-drop']//input")));
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Chaplin Charly");
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        //переключаемся в iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning-uid')]")));
        driver.findElement(By.xpath("//body")).sendKeys("testtesttest");

        Thread.sleep(5000);

        //переключаемся из iframe
        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();

        driver.quit();


    }

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.xpath("//div/input[@id='prependedInput']")).sendKeys("Applanatest1");
        driver.findElement(By.xpath("//div/input[@id='prependedInput2']")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//div/button[@class='btn btn-large  btn-primary pull-right']")).click();
    }
}
