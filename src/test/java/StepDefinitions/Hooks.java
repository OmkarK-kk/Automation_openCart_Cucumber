package StepDefinitions;

import Utilities.ReportNameGenerator;
import Utilities.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.service.ExtentService;
import Utilities.DriverFactory;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import pageObjects.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    public WebDriver driver;
    public Properties properties;
    public Logger logger;
    public LoginPage lp;
    public Homepage hp;
    public MyAccountPage mp;
    public Registration rp;
    public EditAccount ed;
    public static ExtentReports extent;

     private static ThreadLocal<ExtentReports> extentReportsThread = new ThreadLocal<>();
     private static ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {

        // Browser from Maven/System property, default = chrome
        //for property file
       // FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
       // properties = new Properties();
       // properties.load(file);
     //   String browser = System.getProperty("browser","browser");

        String browser = System.getProperty("browser", "chrome");
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
        ExtentService.getInstance().setSystemInfo("os", "windows");

        //Logger initialization
        logger = LogManager.getLogger(Step.class);

        // Page Object initialization
        hp = new Homepage(driver);
        lp = new LoginPage(driver);
        mp = new MyAccountPage(driver);
        rp = new Registration(driver);
        ed = new EditAccount(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        extent.flush();
    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {

            String screenshotName = ScreenshotUtil.captureScreenshot(
                    DriverFactory.getDriver(),
                    scenario.getName()
            );

            byte[] screenshotBytes = ScreenshotUtil.captureScreenshotBytes(
                    DriverFactory.getDriver()
            );

            scenario.attach(screenshotBytes, "image/png", screenshotName);
        }
    }

    @BeforeStep
    public static void setupReport(Scenario scenario) throws IOException {
        // Generate dynamic report name
        String reportPath = "target/ExtentReports/" + ReportNameGenerator.getReportName(scenario.getName());

        // Initialize ExtentSparkReporter with dynamic path
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

        // If you want to still use extent.properties for config, you can load it
        spark.loadXMLConfig("src/test/resources/extent-config.xml"); // optional

        // Attach reporter
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
}
