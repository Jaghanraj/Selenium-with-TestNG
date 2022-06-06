package seleniumTestSamples;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonUsingTestng {
	
	WebDriver Amazon;
	WebElement products;
	List<WebElement> product ;
	String brandName;
	
	
	

	@Test(priority = 1)
	public void getDriver() {

		WebDriverManager.chromedriver().setup();
		Amazon = new ChromeDriver();
		Amazon.get("http://www.google.co.in");
		Amazon.manage().window().maximize();
		Amazon.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(priority = 2)
	public void getWebsite() throws InterruptedException {
		Amazon.findElement(By.name("q")).sendKeys("Amazon" + Keys.ENTER);
		Amazon.findElement(By.xpath("//*[@class=\"CCgQ5 vCa9Yd QfkTvb MUxGbd v0nnCb\"]")).click();
		
	}
	
	@Test(priority = 3)
	public void SearchProduct() {
		Amazon.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("mini camera");		
		Amazon.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}
	@Test(priority = 4)
	public void searchBrandAndDisplay() {
		 product = Amazon.findElements(By.xpath("//*[@aria-labelledby=\"p_89-title\"]"));		
		Amazon.findElement(By.xpath("//*[@id='brandsRefinements']/ul/li[8]/span/div/a/span")).click();		
		 for (int availability = 0; availability < product.size(); availability++) {			 
			 brandName = product.get(availability).getText();			
			System.out.println(brandName);	 
			
			  }
	}			  
			  @Test(priority = 5)
			  public void compareForBrandAvailability() {
			 
			System.out.println("Enter the Brand Name :");
			Scanner scanner = new Scanner(System.in);
			String userInputBrand = scanner.next();
			scanner.close();
	
			if (brandName.contains(userInputBrand)) {				
				System.out.println("Selected Brand is available");
				
			} else {				
				System.out.println("Selected Brand is not available");
			}			
	}	

}

 