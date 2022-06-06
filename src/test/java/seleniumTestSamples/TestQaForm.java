package seleniumTestSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestQaForm {
	@Test
	public void QaForm() {

		WebDriverManager.chromedriver().setup();
		WebDriver Test = new ChromeDriver();
		Test.get("https://demoqa.com/automation-practice-form");

		// Test.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).sendKeys("20");

		WebElement Dob = Test.findElement(By.xpath("(//*[@type=\"text\"])[5]"));
		Dob.clear();
		WebElement date = Test.findElement(By.xpath(
				"//*[@class=\"react-datepicker__day react-datepicker__day--020 react-datepicker__day--selected react-datepicker__day--weekend\"]"));
		date.click();

		Select month = new Select(Test.findElement(By.xpath("react-datepicker__month-select")));
		month.selectByValue("3");

		Select year = new Select(Test.findElement(By.xpath("react-datepicker__month-select")));
		year.selectByValue("2021");
		// Dob.sendKeys("20 may 2022");

		// Test.findElement(By.xpath("(//*[@type=\"text\"])[5]")).click();

	}

}
