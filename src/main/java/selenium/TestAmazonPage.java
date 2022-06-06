package selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAmazonPage {

	static WebDriver Amazon;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		Amazon = new ChromeDriver();
		Amazon.get("http://www.google.co.in");
		Amazon.manage().window().maximize();

		Amazon.findElement(By.name("q")).sendKeys("Amazon" + Keys.ENTER);

		Amazon.findElement(By.xpath("//*[@class='CCgQ5 vCa9Yd QfkTvb MUxGbd v0nnCb']")).click();

		Amazon.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Apple iphone");
		Thread.sleep(3000);
		List<WebElement> list = Amazon
				.findElements(By.xpath("/html/body/div[1]/header/div/div[2]/div/div[2]/div/div/div"));

		for (WebElement webElement : list) {
			if (webElement.getText().equals("apple iphone 13")) {
				webElement.click();
				break;
			}
		}

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
		Amazon.findElement(By.xpath("//*[@id=maindiv\"]/div/div/div[1]/div[1]/a/img")).click();
	}

}
