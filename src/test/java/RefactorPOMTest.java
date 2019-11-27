import pages.BasePage;

import org.junit.Test;
import pages.ConfigPolyPage;
import pages.MainPage;
import pages.TravelInsurancePage;

public class RefactorPOMTest extends BaseTest {

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem("Страхование путешественников");

        TravelInsurancePage travelPage = new TravelInsurancePage(driver);
        travelPage.waitOnlineIssueBtn();
        travelPage.onlineIssueBtn.click();
        travelPage.getNewTabWindow(2);

        ConfigPolyPage configPage = new ConfigPolyPage(driver);         //в конструкторе зашито ожидание элемента
        configPage.insuranceSumm.click();                               //выбор минимального тарифа
        configPage.continueBtn.click();                                 //продолжение

        configPage.fillField(configPage.surNameInsurant, "Pupkin");
        configPage.fillField(configPage.nameInsurant, "Pupkin");
        configPage.fillField(configPage.birthDateInsurant, "02051995");

        configPage.checkFieldErrorMessage("Эл. почта", "Введите адрес электронной почты");
    }
}

