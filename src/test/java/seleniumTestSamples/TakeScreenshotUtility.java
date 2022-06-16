package sortByUsingProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotUtility {
	Properties properties;
	WebDriver loginTest;
	@Test(priority = 1)
	public void getWebsite() throws IOException {
		 WebDriverManager.chromedriver().setup();
		 String userWorkingDirectory = System.getProperty("user.dir");
			String fileSeparator = System.getProperty("file.separator");
			String propPath = userWorkingDirectory + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "java"
					+ fileSeparator + "sortByUsingProperty" + fileSeparator + "loginProperties.properties";
			FileInputStream fileInput = new FileInputStream(propPath);
			properties = new Properties();
			properties.load(fileInput);
			loginTest = new ChromeDriver();
			loginTest.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			loginTest.get(properties.getProperty("url"));
			loginTest.manage().window().maximize();
	}
	@Test(priority = 2)
	public void testPage() {
		
		loginTest.findElement(By.xpath(properties.getProperty("usernameXpath"))).sendKeys(properties.getProperty("userName"));
		loginTest.findElement(By.xpath(properties.getProperty("passwordXpath"))).sendKeys(properties.getProperty("passWord"));
		loginTest.findElement(By.xpath(properties.getProperty("clickLogin"))).click();
		loginTest.findElement(By.xpath(properties.getProperty("invalidUrl"))).click();
		 		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException 
	{
		
		if(ITestResult.FAILURE==result.getStatus())
			Utility.captureScreenshot(loginTest,result.getName());	
		
	}
}
