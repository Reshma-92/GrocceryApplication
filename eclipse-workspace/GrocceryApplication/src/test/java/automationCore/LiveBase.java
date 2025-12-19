package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utility.ScreenshotUtility;

public class LiveBase {
	
	
	Properties prop; //declared globally for use everywhere.
	FileInputStream f; 
	
    public WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    	
    @Parameters("browsers")
    public void initializeBrowser(String browsers) throws Exception {
    	
    	prop = new Properties();
		f = new FileInputStream(Constants.CONFIGFILE);	
		prop.load(f);
		
    	if(browsers.equalsIgnoreCase("Chrome"))   //equalsignorecase - doesn't matter case sensitivity
    	{
    		  driver = new ChromeDriver();
    	}
    	else if(browsers.equalsIgnoreCase("Firefox")) {
    		driver = new FirefoxDriver();
    	}
    	
    	else if(browsers.equalsIgnoreCase("Edge")) {
    		driver = new EdgeDriver();
    	}
    	else {
    		throw new Exception("Invalid browser");
    	}
    	driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
   @AfterMethod(alwaysRun = true)
   public void driverQuit(ITestResult iTestResult) throws IOException {

	if (iTestResult.getStatus() == ITestResult.FAILURE) {

		ScreenshotUtility screenShot = new ScreenshotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
}
		//driver.quit();

	} //iTestResult.getStatus() ➝ Returns an integer (e.g., 1,)
}
