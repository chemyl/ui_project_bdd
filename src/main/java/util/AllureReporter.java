package util;

import gherkin.formatter.model.Result;
import steps.BaseSteps;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Класс, методы которого вызываются по определенному событию.
 * В род классе есть дефолтные методы для обработки событий на любом этапе ЖЦ теста.
 * (старт/падене/игнорирование/завершение...)
 * <p>
 * Переопределение метода testFailure (при падении) - вызвать метод takeScreenshot()
 */

public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter{

    @Override
    public void result (Result testResult) {
        if (testResult.getStatus().equals("failed")) {
            takeScreenshot();
        }
        super.result(testResult);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}