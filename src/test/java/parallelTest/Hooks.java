package parallelTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class Hooks {

    public WebDriver driver;
  //  public Logger logger;
    public LoginPage lp;
    public Homepage hp;
    public MyAccountPage mp;
    public Registration rp;
    public EditAccount ed;
    public Properties properties;


    @Before
    public void setUp() throws IOException {

        properties= new Properties();
        FileInputStream files = new FileInputStream(System.getProperty("user.dir") +"/" +"config.properties");
        properties.load(files);

        String br = properties.getProperty("browser");

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

        switch (br.toLowerCase())
        {
            case "chrome": driver= new ChromeDriver();
            break;

            case "firefox": driver = new FirefoxDriver();
            break;

            case "ie": driver = new InternetExplorerDriver();
            break;

            case "default": System.out.println("Invalid browser..");
            break;
        }

       // System.setProperty("log4j.configurationFile", "log4j2.xml");

      //  driver = new ChromeDriver();
      //  logger = Logger.getLogger("Step");
     //   logger = LogManager.getLogManager().getLogger(String.valueOf(this.getClass()));i
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
    public void tearDown(Scenario sc) {
        if(sc.isFailed()==true)
        {
            String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

            TakesScreenshot Screenshot = (TakesScreenshot) driver;
            File sourceFile = Screenshot.getScreenshotAs(OutputType.FILE);

            String targetFilePath = System.getProperty("user.dir")+"/Screenshots/"+ "_" + timestamp + ".png";
            File targetFile = new File(targetFilePath);

            sourceFile.renameTo(targetFile);
        }
            driver.quit();

    }
}
