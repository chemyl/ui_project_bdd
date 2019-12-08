package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

/**
 * Created by Maltsev A.A
 *
 * Класс работы с главной страницей sberbank.ru/ru/person
 * имплеметнация WebElement и методов с необходимыми действиями
 *
 */

public class MainPage{
    WebDriver driver;

    @FindBy(xpath = "//ul[@class ='lg-menu__list']")
    WebElement menuListBar;

    @FindBy(xpath = "//span[contains(text(),'Страхование')]")
    WebElement insuranceItemOnBar;

//    @FindBy(xpath = "//a[contains(text(),'Страхование путешественников')]")
//    WebElement insuranceMenuTab;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void selectMenuItem(String itemName) {
        menuListBar.findElement(By.xpath("//span[contains(text(),'"+ itemName +"')]")).click();
    }

    public void selectInsuranceItem(String itemName) {
        insuranceItemOnBar.click();
        driver.findElement(By.xpath("//a[@class ='lg-menu__sub-link'][contains(text(),'"+itemName+"')]")).click();
    }
}