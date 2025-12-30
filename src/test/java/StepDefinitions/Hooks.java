package StepDefinitions;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.mortbay.log.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.*;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;


public class Hooks {

    public WebDriver driver;
    public Logger logger;
    public LoginPage lp;
    public Homepage hp;
    public MyAccountPage mp;
    public Registration rp;
    public EditAccount ed;
    public Properties properties;


    @Before
    public void setUp() throws IOException {

        properties = new Properties();
        FileInputStream files = new FileInputStream(System.getProperty("user.dir") + "/" + "config.properties");
        properties.load(files);

        String br = properties.getProperty("browser");
      ExtentService.getInstance().setSystemInfo("os","windows"); //to set system details

       /* if(br.equals("chrome"))
        {

            driver= new ChromeDriver();
        }
        else if(br.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(br.equals("ie"))
        {
            driver = new InternetExplorerDriver();
        }
        else
        {
            System.out.println("Invalid browser selection........");
        }*/

        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "ie":
                driver = new InternetExplorerDriver();
                break;

            case "default":
                System.out.println("Invalid browser..");
                break;
        }

        // System.setProperty("log4j.configurationFile", "log4j2.xml");

        //  driver = new ChromeDriver();
        //  logger = Logger.getLogger("Step");
        logger = LogManager.getLogger(Step.class);
        //  PropertyConfigurator.configure("log4j.properties");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        hp = new Homepage(driver);
        lp = new LoginPage(driver);
        mp = new MyAccountPage(driver);
        rp = new Registration(driver);
        ed = new EditAccount(driver);

    }


    @After
    public void tearDown() {

        /*if (scr.isFailed()) {
            String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

            TakesScreenshot Screenshot = (TakesScreenshot) driver;
            File sourceFile = Screenshot.getScreenshotAs(OutputType.FILE);

            String targetFilePath = System.getProperty("user.dir") + "/Screenshots/" + "_" + timestamp + ".png";
            File targetFile = new File(targetFilePath);

            sourceFile.renameTo(targetFile);
        }*/
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario sc)
    {
        if(sc.isFailed())
        {
            TakesScreenshot Screenshot = (TakesScreenshot) driver;
            byte[] sourceFile = Screenshot.getScreenshotAs(OutputType.BYTES);

            sc.attach(sourceFile,"image/png", sc.getName());
        }
    }
}
