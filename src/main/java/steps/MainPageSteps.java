package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Step - метод отображаемый в отчете Allure ({0} - праметр для передачи в метод)
 * В теле метода вызывается selectItemMenu() / selectInsuranceItem() из класса MainPage
 */

public class MainPageSteps {

    MainPage mainPage = new MainPage();

    @Step("Выбрать из основного меню, пункт {0} ")
    public void selectMenuItem(String menuItem) {
        mainPage.selectMenuItem(menuItem);
    }

    @Step("Выбрать из меню страхования, пункт {0} ")
    public void selectInsuranceItem(String insuranceItem) {
        mainPage.selectInsuranceItem(insuranceItem);
    }
}
