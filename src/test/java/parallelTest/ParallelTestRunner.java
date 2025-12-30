package parallelTest;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".\\Features\\EditAccount.feature"},
        //features = {".\\Features\\EditAccount.feature"},
        glue="parallelTest",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:Reportss/Login1_html.html"}

)

public class ParallelTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
