package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.ConfigPolyPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.sleep;

public class ConfigPageSteps {
    WebDriver driver = BaseSteps.getDriver();
    Actions builder = new Actions(driver);
    ConfigPolyPage configPolyPage = new ConfigPolyPage();


    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        configPolyPage.setUpFields(field, value);
    }

    @Step("Нажать кнопку подтверждения")
    public void confirmBtnClick() {
        builder.moveToElement(configPolyPage.confirmBtn).click().build().perform();
    }

    @Step("Выбрать минимальный тариф страховки")
    public void continueMinTarif() {
        builder.moveToElement(configPolyPage.insuranceSumm).click().build().perform();
    }

    @Step("Нажать кнопку продолжить")
    public void continueBtnClick() {
        sleep(3000);
        builder.moveToElement(configPolyPage.continueBtn).click().build().perform();
    }

    @Step("Проверка ожидаемой и актуальной ошибки заполнения формы")
    public void checkErrorText(String errorMessage) {
        configPolyPage.checkFieldErrorMessage(errorMessage);
    }
}


