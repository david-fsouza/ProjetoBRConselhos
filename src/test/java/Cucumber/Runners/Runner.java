package Cucumber.Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/Features/",
		glue = "Cucumber.Steps",
		//tags = {"~@ignore"},
		plugin = {"pretty", "html:target/CucumberReport/report.html", "json:target/CucumberReport/reportjson.json"},
		monochrome = true,
		dryRun = true
		//strict = false		
		)

public class Runner {

}
