package steps;

import org.openqa.selenium.WebElement;
import pages.ConfigPolyPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class ConfigPageSteps extends BaseSteps {

    @Step("Поле {0} заполняется значением {0}")
    public void stepFillField(WebElement field, String value) {
        new ConfigPolyPage(driver).fillField(field, value);
    }

    // для каждой пары элементов hashmap вызвать метод stepFillFields с передать туда значения этой пары
    @Step("Поле {0} заполняется значением {0}")
    public void StepAllFieldFill(HashMap<WebElement, String> userData) {
        userData.forEach((key, value) ->
                stepFillField(key, value));
    }

    @Step("Проверка ожидаемой и актуальной ошибки заполнения формы")
    public void checkErrorText(String errorMessage) {
        new ConfigPolyPage(driver).checkFieldErrorMessage(errorMessage);
    }

    @Step("Заполнить поле {0} значением {0}")
    public void stepFillHashMap(String field, String value) {
        new ConfigPolyPage(driver).fillHashMap(field,value);
    }
}


