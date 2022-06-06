package seleniumTestSamples;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateFirstCry {
	@Test
	public void FirstCry() throws InterruptedException, IOException {
		WebDriver FirstCry;

		WebDriverManager.chromedriver().setup();
		FirstCry = new ChromeDriver();
		FirstCry.get("http://www.google.co.in");
		FirstCry.manage().window().maximize();

		FirstCry.findElement(By.name("q")).sendKeys("Firstcry" + Keys.ENTER);
		FirstCry.findElement(By.xpath("(//*[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
		Thread.sleep(3000);
		FirstCry.findElement(By.xpath("//*[@class=\"input-text L14_9e\"]")).click();
		Thread.sleep(3000);
		FirstCry.findElement(By.xpath("//*[@class=\"input-text L14_9e\"]")).sendKeys(
				"Babyoye Supima Cotton Full Sleeves Solid Sleep Suit with Bunny Applique and Headband - Pink");
		FirstCry.findElement(By.xpath("//*[@class=\"search-button\"]")).click();
		FirstCry.findElement(By.xpath("//*[@id=\"maindiv\"]/div/div/div[1]/div[1]/a/img")).click();
		TakesScreenshot screenshot = (TakesScreenshot) FirstCry;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		String Picture = "FirstCry";
		File newFile = new File("C:\\Users\\jaghanraj.srinivasan\\Desktop\\"+Picture+".jpg");
		org.openqa.selenium.io.FileHandler.copy(file, newFile);
		FirstCry.quit();
		/*
		 * Thread.sleep(5000); JavascriptExecutor executor = (JavascriptExecutor)
		 * FirstCry; WebElement ImageButton = FirstCry.findElement(By.xpath(
		 * "/html/body/div[5]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/div[1]/div/span[1]"
		 * )); executor.executeScript("arguments[0].scrollIntoView(false)",
		 * ImageButton); ImageButton.click(); Set<String> set =
		 * FirstCry.getWindowHandles(); for (String string : set) {
		 * FirstCry.switchTo().window(string); } FirstCry.findElement(By.xpath(
		 * "//*[@id=\"p_breadcrumb\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/div[1]/div/span[1]/span"
		 * )).click();
		 */
	}

}
