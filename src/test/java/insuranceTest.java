import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maltsev A.A
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
//    @Ignore
//    @Test
    public void mainTest() {
        driver.findElement(By.xpath("//span[contains(text(),'Страхование')]")).click();

        driver.findElement(By.xpath("//a[contains(text(), 'Страхование путешественников')]")).click();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);   //неявное ожидание (просто определенное время)
        String pageTitle = driver.findElement(By.xpath("//h1[contains(text(), 'Страхование путешественников')]")).getText();
        Assert.assertEquals("777", "Страхование путешественников", pageTitle);

        driver.findElement(By.xpath("//a[@target ='_blank']/..//img")).click();
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles()); //Получение списка табов
        driver.switchTo().window(String.valueOf(tabs2.get(1)));      // переключение на вторую вкладку

        WebElement secondPageOpen = driver.findElement(By.xpath("//div[contains(text(),'Минимальная')]"));
        Assert.assertTrue(secondPageOpen.isEnabled());
        driver.findElement(By.xpath("//div[contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//span[@class = 'b-continue-btn']")).click();

        fillField(By.xpath("//input[@ng-model='namespace.SURNAME_ENG']"), "Punkip");          ////insured-input/div/fieldset[2]/div/span
        fillField(By.xpath("//input[@ng-model= 'namespace.NAME_ENG']"), "Petya");                       ////insured-input/div/fieldset[1]/div/span
        fillField(By.xpath("//input[@ng-model= 'namespace.BIRTHDATE']"), "02051993");
        fillField(By.xpath("//input [@name ='surname']"), "Лушевич");
        fillField(By.xpath("//input [@name ='name']"), "Виктор");
        fillField(By.xpath("//input [@name ='middlename']"), "Иакович");
        fillField(By.xpath("//input [@name ='birthDate']"), "Иакович");
        fillField(By.xpath("//input[@placeholder= 'Серия']"), "4515");
        fillField(By.xpath("//input[@placeholder= 'Номер']"), "441526");
        fillField(By.xpath("//input[@name='issueDate']"), "18122015");
        fillField(By.xpath("//textarea[@name='issuePlace']"), "ОУМВД по гор. Москве р-ну Коньково");

        driver.findElement(By.xpath("//span[contains(text(),'Продолжить')]")).click();  //кнопка подтверждения
        Assert.assertEquals("Текст ошибки не корректный", "Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//div[contains(text(),'Заполнены не все обязательные поля')]")).getText());  //проверка текстовки ошибки
    }

    public void fillField(By xPath, String value) {
        driver.findElement(xPath).clear();
        driver.findElement(xPath).sendKeys(value);
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}