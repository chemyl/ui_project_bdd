package pages;

import steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс страницы описывает используемые элементы и необходимые методы/действия с ними
 */

public class TravelInsurancePage {
    // конструктор страницы
    public TravelInsurancePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//a[@target ='_blank']/..//img")
    public WebElement onlineIssueBtn;
}