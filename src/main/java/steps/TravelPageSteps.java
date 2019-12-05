package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelPageSteps extends BaseSteps{

    /**
     * Step - метод отображаемый в отчете Allure ({0} - праметр для передачи в метод)
     * В теле метода вызывается selectItemMenu() из класса MainPage
     */

    @Step("Выбрать из списка Онлайн регистарцию и перейти на неё")
    public void clickOnlineRegistrationBtn() {
        new TravelInsurancePage(driver).onlineIssueBtn.click();
    }

}
