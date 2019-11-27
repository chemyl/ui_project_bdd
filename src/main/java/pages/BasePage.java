package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by Maltsev A.A
 */

public class BasePage {
    WebDriver driver;

    public boolean isElementPresent(By by) {    //метод проверки наличия элемента по BY
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void fillField(WebElement element, String value) {      //метод заполнения WebElement значением value 
        element.clear();
        element.sendKeys(value);
    }

    public void checkFillingOut(String value, WebElement element) {      //метод проверки текстовки в поле
        Assert.assertEquals(value, element.getAttribute("value"));
    }

    public void getNewTabWindow (int tabNumber) {                        //метод переключения между вкладками
        ArrayList tabs = new ArrayList(driver.getWindowHandles());           //получение списка табов
        driver.switchTo().window(String.valueOf(tabs.get(tabNumber)));      // переключение на вторую вкладку
        }
    }