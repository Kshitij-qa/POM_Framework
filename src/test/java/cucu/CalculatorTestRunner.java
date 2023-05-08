package cucu;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/calculator.feature",
        glue = "src/test/java/cucu/CalculatorStepDefinitions"


)

public class CalculatorTestRunner {
}