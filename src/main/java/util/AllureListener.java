package util;

import steps.BaseSteps;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Класс, методы которого вызываются по определенному событию.
 * В род классе есть дефолтные методы для обработки событий на любом этапе ЖЦ теста.
 * (старт/падене/игнорирование/завершение...)
 * <p>
 * Переопределение метода testFailure (при падении) - вызвать метод takeScreenshot()
 */

public class AllureListener extends ru.yandex.qatools.allure.junit.AllureRunListener {

    @Override
    public void testFailure(Failure failure) {
        takeScreenshot();
        super.testFailure(failure);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}