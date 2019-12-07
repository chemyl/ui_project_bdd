package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;

/**
 * Класс страницы описывает используемые элементы и необходимые методы/действия с ними
 */

public class TravelInsurancePage {
    WebDriver driver;

    @FindBy(xpath = "//a[@target ='_blank']/..//img")
    public WebElement onlineIssueBtn;

// конструктор страницы
    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        this.driver = driver;
    }

}