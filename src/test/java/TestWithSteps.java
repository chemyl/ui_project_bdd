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
 * */

public class TestWithSteps extends BaseSteps {

//объекты классов для Step для вызова их методов

    MainPageSteps mainPageSteps = new MainPageSteps();
    TravelPageSteps travelPageSteps = new TravelPageSteps();
    ConfigPageSteps configPageSteps = new ConfigPageSteps();

    @Test
    @Title("Заявка на страхование")
    public void sberInsuranceStepTest(){
        HashMap<String,String> userFields = new HashMap<>();

        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectInsuranceItem("Страхование для туристов");
        travelPageSteps.clickOnlineRegistrationBtn();
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

        configPageSteps.setUpInput(userFields);
        configPageSteps.checkErrorText("Заполнены не все обязательные поля");
    }
}