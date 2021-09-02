package org.example.lesson03.homeWorkProject02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

public class CreateCrmUser {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToCrm();

        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[contains(text(),'Контрагенты')]"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//a/span[contains(text(),'Контактные лица')]")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[@class='btn back icons-holder-text ']")));
        driver.findElement(By.xpath("//div/a[@class='btn back icons-holder-text ']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/input[@name='crm_contact[lastName]']")));
        driver.findElement(By.xpath("//div/input[@name='crm_contact[lastName]']")).sendKeys("LastNameUser");
        driver.findElement(By.xpath("//div/input[@name='crm_contact[firstName]']")).sendKeys("FirstNameUser");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Bins-Haley");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = Collections.singletonList(driver.findElement(By.xpath("//div[@class='select2-result-label']")));
        organizationVars.get(0).click();

        driver.findElement(By.xpath("//div/input[@name='crm_contact[jobTitle]']")).sendKeys("Applanatest");

        driver.findElement(By.xpath("//div/button[contains(text(),'Сохранить и закрыть')]")).click();

        driver.quit();

    }

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.xpath("//div/input[@id='prependedInput']")).sendKeys("Applanatest1");
        driver.findElement(By.xpath("//div/input[@id='prependedInput2']")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//div/button[@class='btn btn-large  btn-primary pull-right']")).click();
    }
}
