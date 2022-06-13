package sortByUsingProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAmazonPage {
	WebDriver Amazon;
	WebElement searchBox;
	Properties properties;

	@Test(priority = 1)
	public void amazonWebpage() throws IOException {

		String userWorkingDirectory = System.getProperty("user.dir");
		String fileSeparator = System.getProperty("file.separator");
		String propPath = userWorkingDirectory + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "java"
				+ fileSeparator + "sortByUsingProperty" + fileSeparator + "productDetails.properties";
		FileInputStream fileInput = new FileInputStream(propPath);
		properties = new Properties();
		properties.load(fileInput);

		WebDriverManager.chromedriver().setup();
		Amazon = new ChromeDriver();
		Amazon.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Amazon.get(properties.getProperty("url"));

	}

	@Test(priority = 2)
	public void selectProduct() {

		searchBox = Amazon.findElement(By.xpath(properties.getProperty("searchPath")));
		searchBox.sendKeys(properties.getProperty("product"));
		Amazon.findElement(By.xpath(properties.getProperty("clickButton"))).click();
	}

	@Test(priority = 3)
	public void getProductPrice() {

		List<WebElement> productPrice = Amazon.findElements(By.cssSelector("[class='a-price-whole']"));
		Map<WebElement, Integer> priceToInteger = new HashMap<WebElement, Integer>();
		for (int key = 0; key < productPrice.size(); key++) {
			if (productPrice.get(key).getText() != "") {
				priceToInteger.put(productPrice.get(key),
						Integer.parseInt(productPrice.get(key).getText().replaceAll(",", "")));
			}

		}
		List<Entry<WebElement, Integer>> lowToHighPrice = new ArrayList<Entry<WebElement, Integer>>(
				priceToInteger.entrySet());
		lowToHighPrice.sort(Entry.comparingByValue());
		for (Entry<WebElement, Integer> entry : lowToHighPrice) 
		{
			System.out.println(entry.getValue());
		}
		lowToHighPrice.get(lowToHighPrice.size() - 1).getKey().click();
	}

}