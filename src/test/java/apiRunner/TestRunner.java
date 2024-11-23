package apiRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
			glue = {"stepDefinitions"},
			//tags="@UpdateClassRecording1",
			plugin = {"pretty", "html:target/cucumber-Reports.html" , "json:target/cucumber.json",
					//"junit:target/Cucumber.xml",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"rerun:target/failed_scenarios.txt"},
			//monochrome = true,
			publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
		
}
