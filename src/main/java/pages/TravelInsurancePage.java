package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Класс страницы описывает используемые элементы и необходимые методы/действия с ними
 */

public class TravelInsurancePage {
    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(), 'Страхование путешественников')]")
    public WebElement pageTitle;

    @FindBy(xpath = "//a[@target ='_blank']/..//img")
    public WebElement onlineIssueBtn;

// конструктор страницы
    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

// метод принимает WebElement и явно ожидает его появления на странице
    public void waitOnlineIssueBtn(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}