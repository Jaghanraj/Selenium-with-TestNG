package seleniumTestSamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablesUsingSelenium {

	public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver link = new ChromeDriver();
		link.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		Thread.sleep(2000);
		link.findElement(By.xpath("//*[@id=\"ez-video-ez-stuck-close\"]"));
		JavascriptExecutor js = (JavascriptExecutor) link;
		js.executeScript("window.scrollBy(0,980)", "");
		WebElement table = link.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		List<WebElement> headers = table.findElements(By.xpath("//th[@scope=\"col\"]"));
		for (WebElement header : headers) {
			String headtext = header.getText();
			System.out.println(headtext);
		}
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
		for (WebElement row : allrows) {
			String rowtext = row.getText();
			System.out.println(rowtext);
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			List<WebElement> rows = allrows.get(i).findElements(By.xpath(
					"//td[@style=\"border-color: rgb(204, 204, 204); border-top-style: solid; border-top-width: 1px; margin: 0px; padding: 5px 10px 5px 5px;\"]"));
			WebElement country = rows.get(1);
			String countrytext = country.getText();
			System.out.println(countrytext);
			WebElement city = rows.get(2);
			String citytext = city.getText();
			System.out.println(citytext);
			WebElement height = rows.get(3);
			String heighttext = height.getText();
			System.out.println(heighttext);
			WebElement built = rows.get(4);
			String builttext = built.getText();
			System.out.println(builttext);
			WebElement Rank = rows.get(4);
			String ranktext = Rank.getText();
			System.out.println(ranktext);

		}

		// link.quit();
	}

}

