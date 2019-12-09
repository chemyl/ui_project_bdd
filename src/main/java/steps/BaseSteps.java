package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
    protected static String targetUrl = properties.getProperty("app.url");

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(targetUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

    public void getNewTabWindow(int tabNumber) {                            //метод переключения между вкладками
        ArrayList tabs = new ArrayList(driver.getWindowHandles());          //получение списка табов
        driver.switchTo().window(String.valueOf(tabs.get(tabNumber)));      //переключение на вторую вкладку
    }

    public static void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }
}