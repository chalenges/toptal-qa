import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/api/features"},
    glue = { "api.steps"},
    plugin = {"json:target/cucumber.json"},
    monochrome = true
)
public class TestRunner {

}
