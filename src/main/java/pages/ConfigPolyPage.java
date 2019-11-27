package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.WEmbeddedFrame;

/**
 * Created by Maltsev A.A
 */

public class ConfigPolyPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Выбор полиса')]")      //первая вкладка страницы
    public WebElement pageLoadTrigger;

    @FindBy(xpath = "//div[contains(text(),'Минимальная')]")
    public WebElement insuranceSumm;

    @FindBy(xpath = "//span[@class = 'b-continue-btn']")
    public WebElement continueBtn;

    @FindBy(xpath = "//input[@ng-model='namespace.SURNAME_ENG']")
    public WebElement surNameInsurant;

    @FindBy(xpath = "//input[@ng-model= 'namespace.NAME_ENG']")
    public WebElement nameInsurant;

    @FindBy(xpath = "//input[@ng-model= 'namespace.BIRTHDATE']")
    public WebElement birthDateInsurant;

    @FindBy(xpath = "//input [@name ='surname']")
    public WebElement surNamePolicyHolder;

    @FindBy(xpath = "//input [@name ='name']")
    public WebElement namePolicyHolder;

    @FindBy(xpath = "//input [@name ='middlename']")
    public WebElement middleNamePolicyHolder;

    @FindBy(xpath = "//input [@name ='birthDate']")
    public WebElement birthDatePolicyHolder;

    @FindBy(xpath = "//input [@placeholder= 'Серия']")
    public WebElement docSeriesPolicyHolder;

    @FindBy(xpath = "//input[@placeholder= 'Номер']")
    public WebElement docNumberPolicyHolder;

    @FindBy(xpath = "//input[@name='issueDate']")
    public WebElement docIssueDate;

    @FindBy(xpath = "//textarea[@name='issuePlace']")
    public WebElement docIssuePlace;

    @FindBy(xpath = "//span[contains(text(),'Продолжить')]")
    public WebElement confirmBtn;

    public ConfigPolyPage(WebDriver driver) {              //конструктор страницы
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))      //явное ожидание видимости PageLoadTrigger
                .until(ExpectedConditions.visibilityOf(pageLoadTrigger));
        this.driver = driver;
    }

    public void inputFields (WebElement fieldName, String value) {  //метод заполнения полей на странице
        fillField(fieldName,value);
    }





    public void checkFieldErrorMessage(String field, String errorMessage) {
        String actualValue = driver.findElement(By.xpath("//div[contains(text(),'"+ errorMessage +"')]")).getText();
        Assert.assertEquals("Получено некорректное значение ошибки","Заполнены не все обязательные поля", actualValue );
    }
}
