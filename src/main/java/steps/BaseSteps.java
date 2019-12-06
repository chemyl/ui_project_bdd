package steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/**
 * Базовый класс шагов, который собирает глобальные методы библиотек и фреймворков Before/AfterClass Attachment
 * Создание driver, properties const
 */

public class BaseSteps {
    protected static WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();
    protected static String baseUrl = properties.getProperty("app.url");

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void getNewTabWindow(int tabNumber) {                            //метод переключения между вкладками
        ArrayList tabs = new ArrayList(driver.getWindowHandles());          //получение списка табов
        driver.switchTo().window(String.valueOf(tabs.get(tabNumber)));      //переключение на вторую вкладку
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}