package sortByUsingProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotErrorInLogin {
	WebDriver loginTest;
	 Properties properties;
	@Test(priority = 0)
	 public void loginPage() throws IOException {
		 
		 
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
	@Test(priority = 1)
	public void testPage() {
		
		loginTest.findElement(By.xpath(properties.getProperty("usernameXpath"))).sendKeys(properties.getProperty("userName"));
		loginTest.findElement(By.xpath(properties.getProperty("passwordXpath"))).sendKeys(properties.getProperty("passWord"));
		loginTest.findElement(By.xpath(properties.getProperty("clickLogin"))).click();
		
		
	}
	@Test(priority = 2)
	public void screenShot() throws IOException {
		
		WebElement successMessage = loginTest.findElement(By.xpath(properties.getProperty("invalidName")));		 
		String expectedMessage = "ERROR";
		String actualMessage = successMessage.getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Actual message not same as expected message");
		if(expectedMessage != actualMessage) {
			
			TakesScreenshot snap = (TakesScreenshot) loginTest;
			File file = snap.getScreenshotAs(OutputType.FILE);
			String picture = "errorTest";
			File newFile = new File("C:\\Users\\jaghanraj.srinivasan\\Desktop\\"+picture+".jpg");
			org.openqa.selenium.io.FileHandler.copy(file, newFile);
						
		}else {
			System.out.println("You login successfully");
		}
		loginTest.quit();
	}
	

}
