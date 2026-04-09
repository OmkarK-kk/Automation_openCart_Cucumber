package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String scenarioName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String screenshotName = scenarioName.replaceAll(" ", "_")
                + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File dest = new File("target/screenshots/" + screenshotName);

        try {
            dest.getParentFile().mkdirs();//gets the parent directory of destination file ,mkdirs() → creates all missing directories in the path
            src.renameTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return screenshotName;
    }

    public static byte[] captureScreenshotBytes(WebDriver driver) {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
}
