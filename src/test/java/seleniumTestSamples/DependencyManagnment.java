package seleniumTestSamples;

import org.testng.annotations.Test;
//This is to show the first method depends on before method
public class DependencyManagnment {
	@Test(enabled = false)
	public void testOne() {
		System.out.println("Open Amazon");
	}

	@Test(dependsOnMethods = "testOne")
	public void testTwo() {
		System.out.println("login functionalities");
	}

	@Test(dependsOnMethods = "testTwo")
	public void testThree() {
		System.out.println("Check add to cart functionality");
	}
}