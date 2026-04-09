package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportNameGenerator {

    public static String getReportName(String testName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        String timestamp = dateFormat.format(new Date());
        return testName + "_" + timestamp + ".html";
    }
}
