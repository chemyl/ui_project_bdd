package steps;

import org.openqa.selenium.WebElement;
import pages.ConfigPolyPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class ConfigPageSteps extends BaseSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        new ConfigPolyPage(driver).setUpFields(field, value);
    }

    // для каждой пары элементов hashmap вызвать метод stepFillField  и  передать туда значения этой пары

    @Step("Заполняются поля через Hashьap")
    public void setUpInput(HashMap<String, String> values) {
        values.forEach((key, value) -> stepFillField(key, value));
    }

    @Step("Проверка ожидаемой и актуальной ошибки заполнения формы")
    public void checkErrorText(String errorMessage) {
        new ConfigPolyPage(driver).checkFieldErrorMessage(errorMessage);
    }

}


