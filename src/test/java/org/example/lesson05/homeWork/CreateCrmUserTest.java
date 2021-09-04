package org.example.lesson05.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class CreateCrmUserTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
        loginToCrm();
    }

    @Test
    void createCrmUser() {

        goToContactFaces();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[@class='btn back icons-holder-text ']")));
        driver.findElement(By.xpath("//div/a[@class='btn back icons-holder-text ']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/input[@name='crm_contact[lastName]']")));
        driver.findElement(By.xpath("//div/input[@name='crm_contact[lastName]']")).sendKeys("Ivar");
        driver.findElement(By.xpath("//div/input[@name='crm_contact[firstName]']")).sendKeys("TheBoneless");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Bins-Haley");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = Collections.singletonList(driver.findElement(By.xpath("//div[@class='select2-result-label']")));
        organizationVars.get(0).click();

        driver.findElement(By.xpath("//div/input[@name='crm_contact[jobTitle]']")).sendKeys("Applanatest");

        driver.findElement(By.xpath("//div/button[contains(text(),'Сохранить и закрыть')]")).click();

        //div[contains(text(),'ФИО')]
        //input[@name='value']
    }

    @Test
    void checkTheUserExist() throws InterruptedException {
        goToContactFaces();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'ФИО')]")));
        driver.findElement(By.xpath("//div[contains(text(),'ФИО')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='value']")));
        driver.findElement(By.xpath("//input[@name='value']")).sendKeys("Ivar TheBoneless");
        driver.findElement(By.xpath("//button[@class='btn btn-primary filter-update']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),'Ivar TheBoneless')]")));
        assertThat(driver.findElement(By.xpath("//td[contains(text(),'Ivar TheBoneless')]")),  hasText("Ivar TheBoneless"));
    }

    @Test
    void checkToCreateNewProject() throws InterruptedException {
        moveToMyProjects();

        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("Revenge to king Aelle && Ecbert");

        driver.findElement(By.xpath("//textarea[@name='crm_project[uniqueDescription]']"))
                .sendKeys("Furthermore, Ragnar telling Ivar to ignore Aelle wasn't him saying \"let Aelle live\" he knew his sons would kill him. It was more in order to emphasise his wish that his sons kill Ecbert, since they may have otherwise ignored him under the illusion that it was Aelle, and Aelle alone, who killed Ragnar,even though it was just as much Ecbert. This way Ragnar got revenge for his people and also got the chance to bring his sons together.");

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

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message']")));
        assertThat(driver.findElement(By.xpath("//div[@class='message']")), hasText("Проект сохранен"));
    }

    @Test
    void checkIsNewProjectExist() throws InterruptedException {
        moveToMyProjects();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='oro-subtitle']")));
        driver.findElement(By.xpath("//div[contains(text(),'Наименование')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='value']")));
        driver.findElement(By.xpath("//input[@name='value']")).sendKeys("Revenge to king Aelle");
        driver.findElement(By.xpath("//button[@class='btn btn-primary filter-update']")).click();

        Thread.sleep(5000);

        List<WebElement> projectsList = driver.findElements(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-name']"));
        assertThat(projectsList.get(0), hasText("Revenge to king Aelle"));
    }

    @Test
    void userWillCanToDeleteExistingProject() throws InterruptedException {
        moveToMyProjects();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='oro-subtitle']")));
        driver.findElement(By.xpath("//div[contains(text(),'Наименование')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='value']")));
        driver.findElement(By.xpath("//input[@name='value']")).sendKeys("Revenge to ");
        driver.findElement(By.xpath("//button[@class='btn btn-primary filter-update']")).click();


        Thread.sleep(5000); //не получилось обработать это ожидание, свалилась на ElementClickIntercepted Exception
        driver.findElement(By.xpath("//tbody[@class='grid-body']/tr[3]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Удалить')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Удалить')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn ok btn-primary']")));
        driver.findElement(By.xpath("//a[@class='btn ok btn-primary']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message']")));
        assertThat(driver.findElement(By.xpath("//div[@class='message']")), hasText("Элемент удален(а)"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.xpath("//div/input[@id='prependedInput']")).sendKeys("Applanatest1");
        driver.findElement(By.xpath("//div/input[@id='prependedInput2']")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//div/button[@class='btn btn-large  btn-primary pull-right']")).click();
    }

    public static void goToContactFaces() {

        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[contains(text(),'Контрагенты')]"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//a/span[contains(text(),'Контактные лица')]")).click();
    }

    public static void moveToMyProjects() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.linkText("Мои проекты")).click();

        Thread.sleep(5000);
    }
}
