package TestRunner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/register.feature", glue = { "StepDefinition",
		"hook" }, plugin = { "pretty", "html:target/cucumber-reports/cucumber_register.html",
				"json:target/cucumber-reports/cucumber_register.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },

		monochrome = true

)
public class Registationrun {

}
