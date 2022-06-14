package sortByUsingProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKartFindRating {
	WebDriver flipKart;
	String totalRate;
	Properties properties;
	 
	
	@Test(priority = 0)
	public void getWebsite() {
		WebDriverManager.chromedriver().setup();
		flipKart = new ChromeDriver();
		flipKart.get("https://www.flipkart.com/");
		flipKart.manage().window().maximize();
	}
	@Test(priority = 1)
	public void getProperties() throws IOException {
		flipKart.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String userWorkingDirectory = System.getProperty("user.dir");
		String fileSeparator = System.getProperty("file.separator");
		String propPath = userWorkingDirectory + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "java"
				+ fileSeparator + "sortByUsingProperty" + fileSeparator + "flipKartReviewProperties.properties";
		FileInputStream fileInput = new FileInputStream(propPath);
		properties = new Properties();
		properties.load(fileInput);
	 

		flipKart.findElement(By.xpath(properties.getProperty("clickCancel"))).click();
		flipKart.findElement(By.xpath(properties.getProperty("searchBar"))).sendKeys(properties.getProperty("Product"));
		flipKart.findElement(By.xpath(properties.getProperty("submitButton"))).click();
		String ratingString = flipKart.findElement(By.xpath(properties.getProperty("rating"))).getText();
		System.out.println("Rating is : " + ratingString);
	 
		List<WebElement> lists = flipKart.findElements(By.xpath(properties.getProperty("totalProduct")));
		List<String> ratingList = new ArrayList<String>();		
		for (WebElement webElement : lists) {
			totalRate = webElement.getText();
			System.out.println("Total product Rating is : " + totalRate);
			ratingList.add(totalRate);
		}

		TreeSet<Double> overallRating = new TreeSet<Double>();
		for (String string : ratingList) {
			double totalRating = Double.parseDouble(string);
			overallRating.add(totalRating);

		}
		System.out.println("Highest rating is : " + overallRating.last());
		System.out.println("Lowest rating is : " + overallRating.first());
		flipKart.quit();
	}
}
