package seleniumTestSamples;

import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class OpenGoogleFromEdge {
	@Test
	public void chrome() {
		
		
		  System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.google.com/");
		
	}

}

/*
 * //How to select for dropDown 1.Create object of the Select class 
 * Select se =new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
 * 
 * 2.Select the option by index 
 * se.selectByIndex(3);
 */