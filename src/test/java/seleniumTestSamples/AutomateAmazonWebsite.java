package seleniumTestSamples;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateAmazonWebsite {
	WebDriver Amazon;
	// Amazon.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	@Test(priority = 1)
	public void getDriver() {

		WebDriverManager.chromedriver().setup();
		Amazon = new ChromeDriver();
		Amazon.get("http://www.google.co.in");
		Amazon.manage().window().maximize();
	}

	@Test(priority = 2)
	public void getWebsite() throws InterruptedException {

		Amazon.findElement(By.name("q")).sendKeys("Amazon" + Keys.ENTER);

		Amazon.findElement(By.xpath("//*[@class=\"CCgQ5 vCa9Yd QfkTvb MUxGbd v0nnCb\"]")).click();

		Amazon.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Apple iphone");

		
		  Thread.sleep(3000); List<WebElement> list = Amazon .findElements(By.xpath(
		  "/html/body/div[1]/header/div/div[2]/div/div[2]/div/div/div"));
		  
		  for (WebElement webElement : list) { if
		  (webElement.getText().equals("apple iphone 13")) { webElement.click(); break;
		  } }
		 
	}

	@Test(priority = 3)
	public void getName() {

		WebElement successMessage = Amazon.findElement(By.xpath(
				"(//*[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"])[1]"));
		String expectedMessage = "Apple iPhone 13 (128GB) - Midnight";
		String actualMessage = successMessage.getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Actual message not same as expected message");
	}

	@Test(priority = 4)
	public void addProduct() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) Amazon;
		WebElement ImageButton = Amazon.findElement(By.xpath(
				"//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[13]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a"));
		executor.executeScript("arguments[0].scrollIntoView(false)", ImageButton);
		ImageButton.click();
		Set<String> set = Amazon.getWindowHandles();
		for (String string : set) {
			Amazon.switchTo().window(string);
		}
		Amazon.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
	
		
	
	}
	@Test(priority = 5)
	public void screenShot() throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot) Amazon;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		String Picture = "amazonCart";
		File newFile = new File("C:\\Users\\jaghanraj.srinivasan\\Desktop\\"+Picture+".jpg");
		org.openqa.selenium.io.FileHandler.copy(file, newFile);
		Amazon.quit();
	}
	

}

