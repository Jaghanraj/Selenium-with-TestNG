package seleniumTestSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateGreenKart {
	WebDriver greenKart;
	@Test(priority = 1)
	public void getDrive() {		
		WebDriverManager.chromedriver().setup();
		greenKart = new ChromeDriver();
		greenKart.get("http://www.google.co.in");
		greenKart.manage().window().maximize();
	}
	@Test(priority = 2)
	public void goToWebsite() {
		greenKart.findElement(By.name("q")).sendKeys("GreenKart" + Keys.ENTER);
		greenKart.findElement(By.xpath("(//*[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
		greenKart.findElement(By.xpath("//*[@class='search-keyword']")).click();
	}
	@Test(priority = 3)
	public void searchAndAddToCart() {
		/*
		 * greenKart.findElement(By.xpath("//*[@class='search-keyword']")).sendKeys(
		 * "Mushroom");
		 * greenKart.findElement(By.xpath("//*[@class='search-button']")).click();
		 */
		greenKart.findElement(By.xpath("(//*[@class='product-action'])[1]")).click();
		greenKart.findElement(By.xpath("(//*[@class='product-action'])[3]")).click();
		greenKart.findElement(By.xpath("(//*[@class='product-action'])[5]")).click();
		greenKart.findElement(By.xpath("(//*[@class='product-action'])[7]")).click();
		
	}
	@Test(priority = 4)
	public void proceedToCheckout() throws InterruptedException {
		Thread.sleep(10000);
		greenKart.findElement(By.cssSelector("img[alt='Cart']")).click();
	}

}
