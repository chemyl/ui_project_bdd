import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ("src/test/resources"),
        glue = {"src/main/java/steps"},
        plugin = {"src/main/java/util.AllureReporter"})

public class CucumberRunner {

}
