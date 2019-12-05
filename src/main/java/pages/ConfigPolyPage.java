package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

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

    public HashMap<WebElement, String> fillHashMap(String fieldName, String value){
        HashMap<WebElement,String> userFields = new HashMap<>();
        switch (fieldName){
            case  "Фамилия":
                userFields.put(surNameInsurant, value);
                break;
            case  "Имя":
                userFields.put(nameInsurant, value);
                break;
            case  "День рождения":
                userFields.put(birthDateInsurant, value);
                break;
            case  "Фамилия страхователя":
                userFields.put(surNamePolicyHolder, value);
                break;
            case  "Имя страхователя":
                userFields.put(namePolicyHolder, value);
                break;
            case  "Отчество страхователя":
                userFields.put(middleNamePolicyHolder, value);
                break;
            case  "День рождения страхователя":
                userFields.put(birthDatePolicyHolder, value);
                break;
            case  "Серия паспорта страхователя":
                userFields.put(docSeriesPolicyHolder, value);
                break;
            case  "Номер паспорта страхователя":
                userFields.put(docNumberPolicyHolder, value);
                break;
            case  "Место выдачи паспорта страхователя":
                userFields.put(docIssuePlace, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
        return userFields;
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия":
                fillField(surNameInsurant, value);
                break;
            case  "Имя":
                fillField(nameInsurant, value);
                break;
            case  "День рождения":
                fillField(birthDateInsurant, value);
                break;
            case  "Фамилия страхователя":
                fillField(surNamePolicyHolder, value);
                break;
            case  "Имя страхователя":
                fillField(namePolicyHolder, value);
                break;
            case  "Отчество страхователя":
                fillField(middleNamePolicyHolder, value);
                break;
            case  "День рождения страхователя":
                fillField(birthDatePolicyHolder, value);
                break;
            case  "Серия паспорта страхователя":
                fillField(docSeriesPolicyHolder, value);
                break;
            case  "Номер паспорта страхователя":
                fillField(docNumberPolicyHolder, value);
                break;
            case  "Место выдачи паспорта страхователя":
                fillField(docIssuePlace, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    public void checkFieldErrorMessage(String errorMessage) {  //проверка текстовки всплывающей ошибки
        String actualValue = driver.findElement(By.xpath("//div[contains(text(),'"+ errorMessage +"')]")).getText();
        Assert.assertEquals("Получено некорректное значение ошибки","Заполнены не все обязательные поля", actualValue );
    }
}
