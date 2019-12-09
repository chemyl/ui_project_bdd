package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import steps.BaseSteps;

import static steps.BaseSteps.sleep;

/**
 * Класс работы с главной страницей sberbank.ru/ru/person
 * имплеметнация WebElement и методов с необходимыми действиями
 */

public class MainPage {
    WebDriver driver = BaseSteps.getDriver();
    Actions builder = new Actions(driver);

    @FindBy(xpath = "//ul[@class ='lg-menu__list']")
    WebElement menuListBar;

    @FindBy(xpath = "//span[contains(text(),'Страхование')]")
    WebElement insuranceItemOnBar;

    @FindBy(xpath = "//a[@class ='lg-menu__sub-link'][contains(text(),'Страхование путешественников')]")
    WebElement travelInsuranceTab;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName) {
        sleep(3000);
        builder.click(menuListBar.findElement(By.xpath("//span[contains(text(),'" + itemName + "')]")));
    }

    public void selectInsuranceItem(String itemName) {
        builder.moveToElement(insuranceItemOnBar).click(insuranceItemOnBar.findElement
                (By.xpath("//a[@class ='lg-menu__sub-link'][contains(text(),'" + itemName + "')]"))).build().perform();
    }
}