import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import casestudy_package.casestudy_project.BrowserClass;


public class demo {
	WebDriver driver;

  @Test
  public void f() {
	  driver = BrowserClass.openBrowser("firefox");
		driver.get("http://www.demoaut.com");
		driver.close();
  }
}
