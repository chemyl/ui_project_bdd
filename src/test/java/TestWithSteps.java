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
        HashMap<WebElement,String> userFields = new HashMap<>();

        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectInsuranceItem("Страхование для туристов");
        travelPageSteps.clickOnlineRegistrationBtn();
        configPageSteps.stepFillHashMap("Имя", "Pupkin");
        configPageSteps.stepFillHashMap("Фамилия", "Pupkin");
        configPageSteps.stepFillHashMap("День рождения", "01071980");
        configPageSteps.stepFillHashMap("Фамилия страхователя", "Лушевич");
        configPageSteps.stepFillHashMap("Имя страхователя", "Лавр");
        configPageSteps.stepFillHashMap("Отчество страхователя", "Поликарпович");
        configPageSteps.stepFillHashMap("Серия паспорта страхователя", "4515");
        configPageSteps.stepFillHashMap("Номер паспорта страхователя", "558669");
        configPageSteps.stepFillHashMap("Серия паспорта страхователя", "4515");
        configPageSteps.stepFillHashMap("Дата выдачи паспорта страхователя", "18122015");
        configPageSteps.stepFillHashMap("Место выдачи паспорта страхователя", "ОУМВД по гор. Москве р-ну Коньково");
        configPageSteps.StepAllFieldFill(userFields);
        configPageSteps.checkErrorText("Заполнены не все обязательные поля");
    }
}