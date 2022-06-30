package sortedPriceToCsvFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenAmazonWebpage {
	Properties properties=null;
	WebDriver Amazon=null;	
	WebElement searchBox=null;

	@Test(priority = 0)
	public void openWebpage() throws IOException {
		String userWorkingDirectory = System.getProperty("user.dir");
		String fileSeparator = System.getProperty("file.separator");
		String propPath = userWorkingDirectory + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "java"
				+ fileSeparator + "sortedPriceToCsvFile" + fileSeparator + "SortPrice.properties";
		FileInputStream fileInput = new FileInputStream(propPath);
		properties = new Properties();
		properties.load(fileInput);

		WebDriverManager.chromedriver().setup();
		Amazon = new ChromeDriver();
		Amazon.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Amazon.get(properties.getProperty("url"));
		Amazon.manage().window().maximize();
	}
	@Test(priority = 1)
	public void searchProduct() {

		searchBox = Amazon.findElement(By.xpath(properties.getProperty("searchBox")));
		searchBox.sendKeys(properties.getProperty("product"));
		Amazon.findElement(By.xpath(properties.getProperty("clickButton"))).click();
	}
	@Test(priority = 2)
	public void filterPrice() {
		
		  WebDriverWait wait = new WebDriverWait(Amazon, Duration.ofSeconds(20));
			/*
			 * WebElement priceRange =
			 * wait.until(ExpectedConditions.elementToBeClickable(Amazon.findElement(By.
			 * xpath(properties.getProperty("Range"))))); priceRange.click();
			 */
		  WebElement priceRange = wait.until(ExpectedConditions.elementToBeClickable(Amazon.findElement(By.xpath(properties.getProperty("minRange")))));
		  priceRange.sendKeys(properties.getProperty("minValue"));
		  Amazon.findElement(By.xpath(properties.getProperty("maxRange"))).sendKeys(properties.getProperty("maxValue"));
		  Amazon.findElement(By.xpath(properties.getProperty("clickGo"))).click();
		 
		
	}
	@Test(priority = 3)
	public void verifyProduct() throws IOException {
		String products = null;
		String prices = null;
		String priceInt = null;		
		List<WebElement> productList = Amazon.findElements(By.xpath(properties.getProperty("productLists")));
		 List<String> productLists =new ArrayList<>();
		System.out.println(productList.size());
		
		for (int index = 0; index < productList.size(); index++) {
		    products = productList.get(index).getText();		   
		    System.out.println(products);
		    productLists.add(products);
			}
		 if (products.contains("OnePlus")) {
			System.out.println("product relates search");
		} else {
			System.out.println("product do not relate search");
		}
		 List<WebElement> price = Amazon.findElements(By.xpath(properties.getProperty("priceList")));
		 List<String> productPrice =new ArrayList<>();
		 //System.out.println(price.size());
		 for (int index = 0; index < price.size(); index++) {
			     priceInt = (price.get(index).getText().replaceAll(",", ""));
			    System.out.println(priceInt);
			    productPrice.add(priceInt);
			  //  productPrice = Integer.parseInt(price.get(index).getText().replaceAll(",", ""));
			   //System.out.println(prices);
				}
		 File file = new File(properties.getProperty("path"));
			FileWriter writer = new FileWriter(file);
			CSVWriter csvWriter = new CSVWriter(writer);
			List<String[]> strings = new ArrayList<String[]>();
			String[] strings1 = productLists.toArray(new String[0]);  //adding each cell of csv
			String[] strings2 = productPrice.toArray(new String[0]);
			strings.add(strings1);
			strings.add(strings2);
			csvWriter.writeAll(strings);
			csvWriter.close();
			Amazon.quit();
		 
			 
		 }
	
	}
	
	
	


