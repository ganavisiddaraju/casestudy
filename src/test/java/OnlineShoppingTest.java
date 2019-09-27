import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import casestudy_package.casestudy_project.Drivers;
import junit.framework.Assert;

public class OnlineShoppingTest {
	WebDriver driver;
	Select sel;
	@BeforeTest
	public void before()
	
	{
		driver=Drivers.getDriver("firefox");
	  driver.get("http://10.232.237.143:443/TestMeApp/");
		
	}
     
 
 @Test(priority=1)
  public void testRegistrtion()
  {
	  
	  Assert.assertEquals(driver.getTitle(), "Home");
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	  driver.findElement(By.linkText("SignUp")).click();
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  Assert.assertEquals(driver.getTitle(), "Sign Up");
	    driver.findElement(By.name("userName")).sendKeys("lalitha");
	  driver.findElement(By.name("firstName")).click();
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  String temp=driver.findElement(By.id("err")).getText();
	  String text="Name Already Exists";
	  if(temp!=text)
	  {
		  driver.findElement(By.name("userName")).sendKeys("sarva987");
		  driver.findElement(By.name("firstName")).sendKeys("sarva987");
		  driver.findElement(By.name("lastName")).sendKeys("hs");
		  driver.findElement(By.name("password")).sendKeys("qwert123");
		  driver.findElement(By.name("confirmPassword")).sendKeys("qwert123");
		  driver.findElement(By.xpath("//input[@type='radio' and @value='Female']")).click();
          driver.findElement(By.name("emailAddress")).sendKeys("asdf@gmail.com");
          driver.findElement(By.name("mobileNumber")).sendKeys("9876543219");
          driver.findElement(By.name("dob")).sendKeys("24/3/1998");
          driver.findElement(By.name("address")).sendKeys("mysore karnataka");
          sel=new Select (driver.findElement(By.name("securityQuestion")));
          sel.selectByIndex(1);
          driver.findElement(By.name("answer")).sendKeys("blue");
          driver.findElement(By.xpath("//input[@type='submit' and @value='Register']")).click();
          Assert.assertEquals(driver.getTitle(), "Login");
	 }
}
 @AfterTest
 public void after()
 {
	 driver.close();
 }
  
}