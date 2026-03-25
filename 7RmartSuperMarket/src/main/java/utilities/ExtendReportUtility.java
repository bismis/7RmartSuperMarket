package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	
	public static final ExtentReports extendReports = new ExtentReports();
	
	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreports/extent-report.html");
		reporter.config().setReportName("SevenRMartSuperMarket");
		extendReports.attachReporter(reporter);
		extendReports.setSystemInfo("organization","Obsqura");
		extendReports.setSystemInfo("Name","Bismi"); 
		return extendReports;
 
	}
		

}
