package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
        //features = {".\\Features"},
        // features = {".\\Features\\EditAccount.feature",".\\Features\\Login.feature"},
        features = {".\\Features\\EditAccount.feature",".\\Features\\Register.feature"},
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
public class FireFoxRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}