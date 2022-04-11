package test.java.utils.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("src/test/java/utils/ExtentReports/extent-report.html");
        reporter.config().setReportName("Practice Automation Testing Extent Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Practice Automation Testing ");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("APPlication Name", "Practice Automation Testing");
        extentReports.setSystemInfo("Author", "WISSEM MACHRAOUI");
        extentReports.setSystemInfo("selenium version","4.1.2");
        return extentReports;
    }

}
