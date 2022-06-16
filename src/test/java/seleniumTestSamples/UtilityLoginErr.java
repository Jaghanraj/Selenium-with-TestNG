package sortByUsingProperty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityLoginErr
{
	WebDriver Pooja;
	@Test
	public void captureScreenshot() 
	{
		WebDriverManager.chromedriver().setup();
		Pooja = new ChromeDriver();		
		Pooja.get("https://practicetestautomation.com/practice-test-login/");
		Pooja.manage().window().maximize();
		Pooja.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Pooja.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("student");
		Pooja.findElement(By.xpath("//*[@name='password']")).sendKeys("Password1234");
		Pooja.findElement(By.xpath("//*[@class=\"btn\"]")).click();	
		Pooja.findElement(By.xpath("//*[@poo(ja)ghan]")).click();
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) 
	{
		
		if(ITestResult.FAILURE==result.getStatus())
			Utility.captureScreenshot(Pooja,result.getName());
		Pooja.quit();
	}
	
	

}
