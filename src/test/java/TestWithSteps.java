import org.junit.Test;
import steps.BaseSteps;
import steps.MainPageSteps;
import steps.TravelPageSteps;
import steps.ConfigPageSteps;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.HashMap;

/**
 * allure отчет (target-site-plugins-index.html)
 */

public class TestWithSteps extends BaseSteps {

    @Test
    @Title("Заявка на страхование")
    public void sberInsuranceStepTest() {
        HashMap<String, String> userFields = new HashMap<>();
        MainPageSteps mainPageSteps = new MainPageSteps();
//Выбор пункта 'Страхование' с главного меню
        mainPageSteps.selectMenuItem("Страхование");
//Выбор пункта 'СТрахование для туристов' с вкладки страхование
        mainPageSteps.selectInsuranceItem("Страхование путешественников");

//Нажать на кнопку (image) онлайн регистрация на стрнице Страхование для туристов
        TravelPageSteps travelPageSteps = new TravelPageSteps();
        travelPageSteps.clickOnlineRegistrationBtn();

//Заполнить HashMap значениями для дальнейшей встравки
        userFields.put("Имя", "Pupkin");
        userFields.put("Фамилия", "Pupkin");
        userFields.put("День рождения", "01071980");
        userFields.put("Фамилия страхователя", "Лушевич");
        userFields.put("Имя страхователя", "Лавр");
        userFields.put("Отчество страхователя", "Поликарпович");
        userFields.put("Номер паспорта страхователя", "558669");
        userFields.put("Серия паспорта страхователя", "4515");
        userFields.put("Дата выдачи паспорта страхователя", "18122015");
        userFields.put("Место выдачи паспорта страхователя", "ОУМВД по гор. Москве р-ну Коньково");

//Переход на открывшуюся новую вкладку
        travelPageSteps.getNewTabWindow(1);

//Выбрать мин тариф страховки и нажать кнопку продолжить
        ConfigPageSteps configPageSteps = new ConfigPageSteps();
        configPageSteps.continueMinTarif();
        configPageSteps.continueBtnClick();

//На странице ConfigPolyPage вызвать метод setUpInput и передать туда HashMap (заполнение полей)
        configPageSteps.setUpInput(userFields);

//Нажать кнопку продолжения
        configPageSteps.confirmBtnClick();

//Проверить текста ошибки, вызвав метод checkErrorText из configPageSteps
        configPageSteps.checkErrorText("Заполнены не все обязательные поля");
    }
}