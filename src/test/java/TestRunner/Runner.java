package TestRunner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
      //features = {".\\Features"},
       // features = {".\\Features\\EditAccount.feature",".\\Features\\Login.feature"},
        features = {".\\Features\\EditAccount.feature"},
        glue="StepDefinitions",
        dryRun = false,
        monochrome = true,
      //  tags = "@sanity",
     //   tags = "@regression",
      //  plugin = {"pretty","html:Reportss/Login1_html.html","rerun:target/failedCases.txt","com.avenstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
    //  plugin = {"pretty","json:Reports/cucumber-reports/Login_json.json"}
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class Runner extends AbstractTestNGCucumberTests {
}
