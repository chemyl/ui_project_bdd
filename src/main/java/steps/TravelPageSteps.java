package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelPageSteps {

    /**
     * Step - метод отображаемый в отчете Allure ({0} - праметр для передачи в метод)
     * В теле метода вызывается  element onlineIssueBtn из класса TravelInsurancePage
     * и кликается
     */

    @Step("Выбрать из списка Онлайн регистарцию и перейти на неё")
    public void clickOnlineRegistrationBtn() {
        new TravelInsurancePage((BaseSteps.getDriver())).onlineIssueBtn.click();
    }

    @Step("Перейти на открывшуюся вкладку регистрации")
    public void getNewTabWindow(int tabCount) {
        new BaseSteps().getNewTabWindow(tabCount);
    }
}
