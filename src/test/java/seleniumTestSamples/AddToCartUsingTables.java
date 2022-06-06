package seleniumTestSamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCartUsingTables {
	WebDriver link;
	int columnSize;

	@Test(priority = 1)
	public void getWebsite() {
		WebDriverManager.chromedriver().setup();
		link = new ChromeDriver();
		link.get("https://www.techlistic.com/p/demo-selenium-practice.html");
	}

	@Test(priority = 2)
	public void scrollWebsite() {
		link.findElement(By.xpath("//*[@id=\"ez-video-ez-stuck-close\"]"));
		JavascriptExecutor js = (JavascriptExecutor) link;
		js.executeScript("window.scrollBy(0,980)", "");
	}

	@Test(priority = 3)
	public void showHeaders() // Sorted list header
	{
		WebElement table = link.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		List<WebElement> headers = table.findElements(By.xpath("//th[@scope=\"col\"]"));
		 columnSize = headers.size();
		System.out.println("column size : "+columnSize);
		System.out.println("***Details Shown for Buildings***");
		for (WebElement header : headers) {
			String headtext = header.getText();
			System.out.println(headtext);
		}
	}

	@Test(priority = 4) // Sorted list elements
	public void listElementsInList() {
		List<WebElement> allrows = link.findElements(By.xpath("//th[@scope=\"row\"]"));
		allrows.remove(0);
		int size = allrows.size();
		System.out.println("Structure Size" + "-" + size);
		if (size == 4) {
			System.out.println("It has 4 structure only");
			System.out.println();
		} else {
			System.out.println("Incorrect structure");
		}
		System.out.println();
		System.out.println("***Name Of Top Building Structure Shown***");
		for (int r = 1; r <= size; r++) {
			for (int c = 1; c < columnSize; c++) {
				String data = link
						.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]//tbody/tr[" + r + "]/td[" + c + "]"))
						.getText();
				System.out.println(data);

			}

		}
	}

	@Test(priority = 5)
	public void showBurjKalifaDetails() {
		WebElement table = link.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		List<WebElement> burjKalifa = table.findElements(By.xpath("(//tbody/tr)[8]"));
		for (WebElement webElement : burjKalifa) {
			String burjAttributes = webElement.getText();
			System.out.println();
			System.out.println(burjAttributes);
			
		}
	}

	@Test(priority = 6)
	public void showClockTowerHotelDetails() {
		WebElement table = link.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		List<WebElement> clockToweHotel = table.findElements(By.xpath("(//tbody/tr)[9]"));
		for (WebElement webElement : clockToweHotel) {
			String clockAttributes = webElement.getText();
			System.out.println();
			System.out.println(clockAttributes);
		}
	}

	@Test(priority = 7)
	public void showTaipei101Dteails() {
		WebElement table = link.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		List<WebElement> Taipei101 = table.findElements(By.xpath("(//tbody/tr)[10]"));
		for (WebElement webElement : Taipei101) {
			String taipeiAttributes = webElement.getText();
			System.out.println();
			System.out.println(taipeiAttributes);
		}
	}

	@Test(priority = 8)
	public void showFinancialCenterDetails() {
		WebElement table = link.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		List<WebElement> financialCenter = table.findElements(By.xpath("(//tbody/tr)[11]"));
		for (WebElement webElement : financialCenter) {
			String financialCenterAttributes = webElement.getText();
			System.out.println();
			System.out.println(financialCenterAttributes);
		}

	}
	@Test(priority = 9)
	public void heightOfBurjKalifa() {
		int row = link.findElements(By.xpath("//table[@class='tsc_table_s13']")).size();
		for (int rowOne = 1; rowOne <= row; rowOne++) {
			String name = link.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + rowOne + "]/th")).getText();
			if (name.equals("Burj Khalifa")) {
				String height =link.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + rowOne + "]/td[3]")).getText();
				System.out.println();
				System.out.println("Highest Building : " +name+"Building height : "+height);
			} else {

			}
		}
	}

	@Test(priority = 10)
	public void VerifyColumnValue() {
		// WebElement table =
		// link.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		int lastColumn = link
				.findElements(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tfoot")).size();
		//int sizeOfLastColumn = lastColumn.size();
		System.out.println();
		System.out.println("SizeOfLastColumn :" + lastColumn);
		System.out.println();
	}

	{
		// WebElement table =
		// link.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		/*
		 * List<WebElement> allColumns=link.findElements(By.
		 * xpath("(//*[@style=\"margin: 0px; padding: 0px;\"])[3]")); int
		 * size=allColumns.size(); System.out.println("Column size :" +size);
		 * if(size==2){ System.out.println("pass"); } else
		 * 
		 * System.out.println("fail"); }
		 */

		/*
		 * //click on column link.findElement(By.xpath("(//tr/th)[4]")).click();
		 * 
		 * //capture element to list link.findElement(By.xpath(""));
		 */

	}
}
