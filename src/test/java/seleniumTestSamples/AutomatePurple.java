package seleniumTestSamples;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomatePurple {
	WebDriver purple;
	List<WebElement> list;

	@Test(priority = 1)
	public void getDrive() {

		WebDriverManager.chromedriver().setup();
		purple = new ChromeDriver();
		purple.get("http://www.google.co.in");
		purple.manage().window().maximize();
	}

	@Test(priority = 2)
	public void getWebsite() {
		purple.findElement(By.name("q")).sendKeys("Purple" + Keys.ENTER);
		purple.findElement(By.xpath("(//*[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
		purple.findElement(By.xpath(
				"//*[@id=\"body\"]/app/main/home/header-content/div[2]/header/div/div[3]/div/div/div[1]/div/span/i"))
				.click();
		purple.findElement(By.xpath(
				"//*[@id=\"body\"]/app/main/home/header-content/div[3]/search-content/div[1]/div/div[1]/p/input"))
				.sendKeys("Mac lipstick");
	}

	@Test(priority = 3)
	public void getBrand() throws InterruptedException {

		Thread.sleep(3000);
		list = purple.findElements(By.xpath("//*[@class='pp-1-3 brr1s bc-f2']"));

		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).getText();
			System.out.println(name);
			if (name.contains("Mac Lipstick")) {
				purple.findElements(By.xpath("(//span[text()='Mac Lipstick'])[1]")).get(i).click();
				break;
			}
		}
	}

	@Test(priority = 4)
	public void addToCart() throws InterruptedException, IOException {
		Thread.sleep(3000);
		purple.findElement(By.xpath("//*[@id=\"237912\"]")).click();
		Thread.sleep(3000);
		purple.findElement(By.xpath("//*[@class='p-basket f50 vam']")).click();
	}

	@Test(priority = 5)
	public void takeScreenShot() throws IOException, InterruptedException {
		Thread.sleep(15000);
		TakesScreenshot screenshot = (TakesScreenshot) purple;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		String Picture = "Cart";
		File newFile = new File("C:\\Users\\jaghanraj.srinivasan\\Desktop\\" + Picture + ".jpg");
		org.openqa.selenium.io.FileHandler.copy(file, newFile);
		purple.quit();
	}

}

		
