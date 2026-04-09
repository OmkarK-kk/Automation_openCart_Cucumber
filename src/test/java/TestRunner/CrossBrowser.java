package TestRunner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import Utilities.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
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
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failedCases.txt"
        }
)
public class CrossBrowser extends AbstractTestNGCucumberTests {


    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setup(String browser) {
       DriverFactory.initDriver(browser);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown()
    {
        DriverFactory.quitDriver();
    }
}

