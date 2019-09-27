import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import casestudy_package.casestudy_project.Drivers;
import junit.framework.Assert;

public class study {
	WebDriver driver;
	@BeforeTest
	public void before()
	
	{
		driver=Drivers.getDriver("chrome");
	  driver.get("http://10.232.237.143:443/TestMeApp/");
		
	}
     
	 @Test(priority=1)
	  public void testLogin() {
		 
		  Assert.assertEquals(driver.getTitle(), "Home");
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  driver.findElement(By.linkText("SignIn")).click();
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.findElement(By.name("userName")).sendKeys("lalitha");
		 driver.findElement(By.name("password")).sendKeys("Password123");
		 driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
	     Assert.assertEquals(driver.getTitle(), "Home");
	  }
	 @Test(priority=2)
	 public void testCart()
	 {
		 
		driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();
		 //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    Actions act=new Actions(driver);
		   act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"))).build().perform();
		    System.out.println("success");
		    driver.findElement(By.linkText("Electronics")).click();
		    WebDriverWait wait=new WebDriverWait(driver,100);
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Head Phone")));
		    driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click();
		    Assert.assertEquals(driver.getTitle(), "Search");
		    //  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		   // driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]")).click();
		    Assert.assertEquals(driver.getTitle(), "View Cart");
		    
		   
	 }
	 @Test(priority=3)
	 public void testPayment()
	 {
		 Assert.assertEquals(driver.getTitle(), "View Cart");
		 driver.findElement(By.xpath("/html/body/main/section/div[3]/table/tfoot/tr[2]/td[5]/a")).click();
		 Assert.assertEquals(driver.getTitle(), "Cart Checkout");
		 driver.findElement(By.xpath("//input[@type='submit' and @value='Proceed to Pay']")).click();
		 WebDriverWait wait=new WebDriverWait(driver,100);
		   wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/h3"), "Net Banking"));
		   driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label")).click();//andhrabank
		   driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();//continue
		   
		   driver.findElement(By.name("username")).sendKeys("123456");
		   driver.findElement(By.name("password")).sendKeys("Pass@456");
		   driver.findElement(By.xpath("//input[@type='submit' and @value='LOGIN']")).click();//login button
		   driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		   driver.findElement(By.xpath("//input[@type='submit' and @value='PayNow']")).click();
		   Assert.assertEquals(driver.getTitle(), "Order Details");
	 }
	 @AfterTest
	 public void after()
	 {
		 driver.close();
	 }
	 
		
}
