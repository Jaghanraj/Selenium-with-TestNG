package seleniumTestSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

 

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenYouTubeAndPriorityCheck {
	WebDriver driver;

	@Test(enabled = true)
	public void getDrive() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	@Test(priority = 1)
	public void getWebsite() {

		driver.get("http://www.google.co.in");
	}

	@Test(priority = 2)
	public void typeSong() {

		driver.findElement(By.name("q")).sendKeys("Munbe vaa Video song tamil" + Keys.ENTER);

		driver.findElement(By.xpath("//*[text()='Sillunu Oru Kadhal Tamil Movie Songs HD | Munbe Vaa Song']")).click();
	}
}
