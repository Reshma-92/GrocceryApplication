package utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

    private static ExtentReports extent;

    public synchronized static ExtentReports createExtentReports() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")    //Gets the project root directory
                    + File.separator + "extent-reports"
                    + File.separator + "extent-report.html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportPath);

            reporter.config().setReportName("7RMartSupermarketProject");   //Sets the name shown inside the report

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Organization", "Obsqura");
            extent.setSystemInfo("Name", "Reshma");
        }

        return extent;
    }
}
