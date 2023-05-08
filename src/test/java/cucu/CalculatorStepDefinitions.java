package cucu;
import cucuMain.Calculator;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class CalculatorStepDefinitions {
    private Integer result;
    private Calculator calculator;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer num1, Integer num2) {
        result = calculator.add(num1, num2);

    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer expectedResult) {
        Assert.assertEquals(result,expectedResult);

    }
}
