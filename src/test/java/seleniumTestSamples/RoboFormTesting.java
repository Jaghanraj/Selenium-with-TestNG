package seleniumTestSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoboFormTesting {
	@Test
	public void testRoboForm() {
// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver Test = new ChromeDriver();
		Test.get("https://www.roboform.com/filling-test-all-fields");
		Test.findElement(By.xpath("//*[@type=\"text\"][1]")).sendKeys("Tnpsc");
		Test.findElement(By.xpath("//*[@name=\"02frstname\"]")).sendKeys("jaghan");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[3]")).sendKeys("raj");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[4]")).sendKeys("Srinivasan");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[5]")).sendKeys("Jaghanraj Srinivasan");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[6]")).sendKeys("Atmecs");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[7]")).sendKeys("Software Engineer");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[8]")).sendKeys("Cuddalore");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[9]")).sendKeys("Allur");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[10]")).sendKeys("Cuddalore");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[11]")).sendKeys("TamilNadu");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[12]")).sendKeys("India");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[13]")).sendKeys("607002");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[14]")).sendKeys("6385230864");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[15]")).sendKeys("9578063853");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[16]")).sendKeys("04122-26257");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[17]")).sendKeys("04122-26250");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[18]")).sendKeys("jaghan@gmail.com");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[19]")).sendKeys("www.tnpsc.com");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[20]")).sendKeys("jaghanraj");
		Test.findElement(By.xpath("(//*[@type=\"password\"])")).sendKeys("welcome@123");

//credit card button
		Test.findElement(By.xpath("(//*[@type=\"text\"])[21]")).sendKeys("6678 0987 4536");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[22]")).sendKeys("098");
//card expiration date
		Test.findElement(By.xpath("(//*[@type=\"text\"])[23]")).sendKeys("JaghanRaj");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[24]")).sendKeys("ICICI");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[25]")).sendKeys("9578063853");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[26]")).sendKeys("Male");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[27]")).sendKeys("04122-26274");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[28]")).sendKeys("65425370982654");
//date of birth
		Test.findElement(By.xpath("(//*[@type=\"text\"])[29]")).sendKeys("21");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[30]")).sendKeys("Cuddalore");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[31]")).sendKeys("3,250000");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[32]")).sendKeys("Good");
		Test.findElement(By.xpath("(//*[@type=\"text\"])[33]")).sendKeys("No comments");
		
		Select cardType = new Select(Test.findElement(By.xpath("//*[@name=\"40cc__type\"]")));
		cardType.selectByValue("6");
		
		Select expDate = new Select(Test.findElement(By.xpath("//*[@name=\"42ccexp_mm\"]")));
		expDate.selectByValue("03");
		
		Select expYear = new Select(Test.findElement(By.xpath("//*[@name=\"43ccexp_yy\"]")));
		expYear.selectByValue("2024");
		
		
		
	}

}
