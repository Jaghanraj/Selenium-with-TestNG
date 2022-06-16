package sortByUsingProperty;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void captureScreenshot(WebDriver driver,String screenshotName) {
		
		try {
			TakesScreenshot snap = (TakesScreenshot) driver;
			
			File source = snap.getScreenshotAs(OutputType.FILE);
			
			String picture = "errorTest";
			
			FileUtils.copyFile(source,new File("C:\\Users\\jaghanraj.srinivasan\\Desktop\\"+picture+".jpg"));
			
			System.out.println("Sreenshot Taken");
		
	}catch(Exception e) {
		System.out.println("Exception while taking screenshot "+e.getMessage());
	}

}
}