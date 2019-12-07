package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {

    /**
     * Step - метод отображаемый в отчете Allure ({0} - праметр для передачи в метод)
     * В теле метода вызывается selectItemMenu() / selectInsuranceItem() из класса MainPage
     */

    @Step("Выбрать из основного меню, пункт {0} ")
    public void selectMenuItem(String menuItem) {
        new MainPage((BaseSteps.getDriver())).selectMenuItem(menuItem);
    }

    @Step("Выбрать из меню страхования, пункт {0} ")
    public void selectInsuranceItem(String insuranceItem) {
        new MainPage((BaseSteps.getDriver())).selectInsuranceItem(insuranceItem);
    }
}
