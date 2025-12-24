package abhishek.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Abhishek");
		
		
	}

	@Test
	public void initialDemo() {
		extent.createTest("Initial Demo");
		//WebDriverManager.chromedriver().setup();

		//System.setProperty("webdriver.chrome.driver","C://drivers//chromedriver.exe");
//		 ChromeOptions options = new ChromeOptions();
//		    options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		    
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();
	}
	
	public void start() {
		System.out.println("Started");
		System.out.println("Modified");
	}
}
