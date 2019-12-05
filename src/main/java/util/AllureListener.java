package util;

import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;
import steps.BaseSteps;

/**
 *
 * Класс, методы которого вызываются по определенному событию.
 * В род классе есть дефолтные методы для обработки событий на любом этапе ЖЦ теста.
 * (старт/падене/игнорирование/завершение...)
 *
 * Переопределение метода testFailure (при падении) - вызвать метод takeScreenshot()
 * */

public class AllureListener extends AllureRunListener {

    @Override
    public void testFailure(Failure failure){
        BaseSteps.takeScreenshot();
        super.testFailure(failure);
    }
}