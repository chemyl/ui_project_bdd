package steps;

import java.util.HashMap;
import pages.ConfigPolyPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ConfigPageSteps {

    ConfigPolyPage configPolyPage = new ConfigPolyPage((BaseSteps.getDriver()));

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        configPolyPage.setUpFields(field, value);
    }

    // для каждой пары элементов hashmap вызвать метод stepFillField  и  передать туда значения этой пары
    @Step("Заполняются поля через HashMap")
    public void setUpInput(HashMap<String, String> values) {
        values.forEach((key, value) -> stepFillField(key,value));
    }

    @Step("Нажать кнопку подтверждения")
    public void confirmBtnClick() {
        configPolyPage.confirmBtn.click();
    }

    @Step("Выбрать минимальный тариф страховки")
    public void continueMinTarif() {
        configPolyPage.insuranceSumm.click();
    }

    @Step("Нажать кнопку продолжить")
    public void continueBtnClick() {
        configPolyPage.continueBtn.click();
    }

    @Step("Проверка ожидаемой и актуальной ошибки заполнения формы")
    public void checkErrorText(String errorMessage) {
        configPolyPage.checkFieldErrorMessage(errorMessage);
    }
}


