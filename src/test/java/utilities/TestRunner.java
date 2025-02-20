package utilities;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
        features = {"src/test/java/features"},
        glue = {"tests"},
        plugin = {"pretty", "html:target/report/html-report.html"})

public class TestRunner extends AbstractTestNGCucumberTests {
}
