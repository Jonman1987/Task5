package ru.academits;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.module.Configuration;
import java.time.Duration;

public class WebDriverTests {
    WebDriver driver = null;

    @BeforeEach
    public void setUp(){
        String browser = "chrome"; //пока жестко прописал браузер, потому что он запускается с null
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }else if(browser.equals("edge")){
            driver = new EdgeDriver();
        }
    }

    @Test
    public void OpenDemoTest(){

        WebDriverWait wait;
        //Я попытался сделать ожидание, но лекционный пример wait = new WebDriverWait(driver, 300, 500) выдает ошибку
        // wait = new WebDriverWait(driver, Duration.ofSeconds(30)); - я нашел такую замену
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement name = driver.findElement(By.id("firstName"));
        name.sendKeys("Evgeny");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Danilov");

        WebElement eMail = driver.findElement(By.id("userEmail"));
        eMail.sendKeys("Jonman@yandex.ru");

        WebElement gender = driver.findElement(By.xpath("//div[@id='genterWrapper']/div[2]/div/label"));
        gender.click();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("9831344175");

        //здесь я не смог реализовать ожидание, так как лекционный пример выдает ошибку в строке presenceOfElementLocated - пишет, что нет такой функции
        //WebElement dateOfBirth = driver.findElement(By.xpath("//div[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]"));
        //wait.until(ExpectedCondition.presenceOfElementLocated(By.xpath("//div[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]")));
        //dateOfBirth.click();

        //Здесь так же не совсем понял как действовать через select
        //WebElement subjectsContainer = driver.findElement(By.xpath("//div[@id='subjectsContainer']/div/div"));
        //Select t = new Select(subjectsContainer);
        //t.selectByIndex(0);

        WebElement hobbies = driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div/label"));
        hobbies.click();
        WebElement hobbies2 = driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div[3]/label"));
        hobbies2.click();

        WebElement curentAddress = driver.findElement(By.id("currentAddress"));
        curentAddress.sendKeys("Kropotkina");

        //Здесь почему то список реализован не как в лекционном примере через select - не могу найти элемент взаимодействия. Ощущение, что он берет значения из подгружаемого класса.
        //WebElement city = driver.findElement(By.id("react-select-3-input"));
        //Select c = new Select(city);
        //c.selectByIndex(0);

        //С кнопкой так же не могу понять принцип взаимодействия. Я вроде выбрал правильный селектор по id но клик не работает
        //WebElement button = driver.findElement(By.xpath("//[@id='submit']"));
        //button.click();
        }

    @After
    public void tearDown(){
        driver.quit();
    }
}
