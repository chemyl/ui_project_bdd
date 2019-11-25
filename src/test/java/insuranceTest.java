import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

/**
 * Created by
 * chemyl.inc
 * on 25/11/19
 */


public class insuranceTest {
    WebDriver driver;
    String baseURL;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseURL = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void mainTest() {
        driver.findElement(By.xpath("//span[contains(text(),'Страхование')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Страхование путешественников')]")).click();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        String pageTitle  = driver.findElement(By.xpath("//h1[contains(text(), 'Страхование путешественников')]")).getText();
        Assert.assertEquals("777", "Страхование путешественников ",pageTitle);
        driver.findElement(By.xpath("//a[contains (text(),'Оформить сейчас')]")).click();
            WebElement secondPage = driver.findElement(By.xpath("//span[contains (text(),'Выбор полиса')]"));
        Assert.assertTrue(secondPage.isDisplayed());
        driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();
        fillField(By.xpath("//*[contains(text(),'Введите Фамилию на латинице')]"), "Punkip");          ////insured-input/div/fieldset[2]/div/span
        fillField(By.xpath("//*[contains(text(),'Введите Имя на латинице')]"), "Petya");                       ////insured-input/div/fieldset[1]/div/span
        fillField(By.id("//*[@id='dp1574709754507']"),"02051993");
        fillField(By.name("//input [@name ='surname']"),"Лушевич");
        fillField(By.name("//input [@name ='name']"),"Виктор");
        fillField(By.name("//input [@name ='middlename']"),"Иакович");
        fillField(By.name("//input [@name ='birthDate']"),"Иакович");

    }

    public void fillField(By xPath, String value){
            driver.findElement(xPath).clear();
            driver.findElement(xPath).sendKeys(value);
    }



    @After
    public void afterTest() {

    }
}
