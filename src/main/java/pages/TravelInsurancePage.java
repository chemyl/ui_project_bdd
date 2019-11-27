package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TravelInsurancePage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(), 'Страхование путешественников')]")
    public WebElement pageTitle;

    @FindBy(xpath = "//a[@target ='_blank']/..//img")
    public WebElement onlineIssueBtn;

    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void waitOnlineIssueBtn() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(onlineIssueBtn));
    }
}
