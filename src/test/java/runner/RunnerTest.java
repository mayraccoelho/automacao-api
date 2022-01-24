package runner;

import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.Locale;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "steps",
        plugin = {"json:target/reports/CucumberReports.json", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/",
        tags = "@categorias"
)
public class RunnerTest {

}
