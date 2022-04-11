package testrunners;

import com.cucumber.listener.Reporter;
import com.qa.util.ConfigReader;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import jdk.jfr.events.FileReadEvent;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


import java.io.File;
import java.io.FileReader;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/parallel"
		,glue={""},
//		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
//				"junit:target/cucumber-reports/Cucumber.xml",
//				"html:target/cucumber-reports"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true
)
public class MyTestRunner {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig("extent-config.xml");
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}

}
