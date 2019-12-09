package pages;

import steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс страницы со всеми необходимыми полями ввода значений,
 * кнопками и методами работы с ними
 */

public class ConfigPolyPage {
    public ConfigPolyPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

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

    //      по FieldName вызывает метод и передает нужный webElement и value
    public void setUpFields(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия":
                fillField(surNameInsurant, value);
                break;
            case "Имя":
                fillField(nameInsurant, value);
                break;
            case "День рождения":
                fillField(birthDateInsurant, value);
                break;
            case "Фамилия страхователя":
                fillField(surNamePolicyHolder, value);
                break;
            case "Имя страхователя":
                fillField(namePolicyHolder, value);
                break;
            case "Отчество страхователя":
                fillField(middleNamePolicyHolder, value);
                break;
            case "День рождения страхователя":
                fillField(birthDatePolicyHolder, value);
                break;
            case "Серия паспорта страхователя":
                fillField(docSeriesPolicyHolder, value);
                break;
            case "Номер паспорта страхователя":
                fillField(docNumberPolicyHolder, value);
                break;
            case "Дата выдачи паспорта страхователя":
                fillField(docIssueDate, value);
                break;
            case "Место выдачи паспорта страхователя":
                fillField(docIssuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    //    метод заполнения WebElement значением value
    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    //    проверка текстовки всплывающей ошибки
    public void checkFieldErrorMessage(String errorMessage) {
        String actualValue = BaseSteps.getDriver().findElement(By.xpath("//div[contains(text(),'" + errorMessage + "')]")).getText();
        Assert.assertEquals("Получено некорректное значение ошибки", "Заполнены не все обязательные поля", actualValue);
    }
}