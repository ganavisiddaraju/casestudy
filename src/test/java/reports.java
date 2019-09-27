import java.io.File;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.concurrent.TimeUnit;




import org.apache.commons.io.FileUtils;
 import org.openqa.selenium.By;
 import org.openqa.selenium.OutputType;
 import org.openqa.selenium.TakesScreenshot;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.interactions.Actions;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.Select;
 import org.openqa.selenium.support.ui.WebDriverWait;
 import org.testng.Assert;
 import org.testng.ITestResult;
 import org.testng.SkipException;
 import org.testng.annotations.AfterMethod;
 import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;




import com.relevantcodes.extentreports.ExtentReports;
 import com.relevantcodes.extentreports.ExtentTest;
 import com.relevantcodes.extentreports.LogStatus;




 import casestudy_package.casestudy_project.Drivers;


public class reports {
  ExtentReports extent;
  ExtentTest logger;
  WebDriver driver;




 @BeforeTest
  public void startReport() {
   extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Reports.html", true);
   extent.addSystemInfo("Host Name", "TestMe");
   extent.addSystemInfo("Environment", "Selenium Testing");
   extent.addSystemInfo("User Name", "Lekha Nair");
  }




 public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
   String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
   TakesScreenshot ts = (TakesScreenshot) driver;
   File source = ts.getScreenshotAs(OutputType.FILE);
   String destination = System.getProperty("user.dir") + "/FailedScreenshots/" + screenshotName + dateName
     + ".png";
   File finalDestination = new File(destination);
   FileUtils.copyFile(source, finalDestination);
   return destination;
  }




 @Test
  public void passTest() {
   logger = extent.startTest("passTest");
   Assert.assertTrue(true);
   logger.log(LogStatus.PASS, "Test Case Passed is passTest");
   
   driver = Drivers.getDriver("Chrome");
   driver.get("http://10.232.237.143:443/TestMeApp/");
   
   
      //registration
   String temp="Name Already Exists";
   Select sel;
   Assert.assertEquals(driver.getTitle(), "Home");
     
     driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
     driver.findElement(By.linkText("SignUp")).click();
     
    Assert.assertEquals(driver.getTitle(), "Sign Up");
     driver.findElement(By.name("userName")).sendKeys("SAVITHA");
    
     driver.findElement(By.name("firstName")).click();
     driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
     String text=driver.findElement(By.id("err")).getText();
     driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
     System.out.println(text);
     if(text.equals(temp))
     {
    	 System.out.println("user regiistred") ;
    	 driver.findElement(By.linkText("Home")).click();
    	 driver.findElement(By.linkText("SignIn")).click();
     }
    
     else{
    
      driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
      driver.findElement(By.name("userName")).sendKeys("nikitha5");
      driver.findElement(By.name("firstName")).sendKeys("nikitha5");
      driver.findElement(By.name("lastName")).sendKeys("mangala1");
      driver.findElement(By.name("password")).sendKeys("ash1234");
      driver.findElement(By.name("confirmPassword")).sendKeys("ash1234");
      driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//input[@type='radio' and @value='Female'] ")).click();
      
      
      driver.findElement(By.name("emailAddress")).sendKeys("ganavi@gmail.com");
      driver.findElement(By.name("mobileNumber")).sendKeys("8838309039");
      driver.findElement(By.name("dob")).sendKeys("31/12/1997");
      driver.findElement(By.name("address")).sendKeys("mysusrus karnataka");
      sel=new Select (driver.findElement(By.name("securityQuestion")));
      sel.selectByIndex(1);
      driver.findElement(By.name("answer")).sendKeys("blue");
      driver.findElement(By.xpath("//input[@type='submit'] ")).click();
      Assert.assertEquals(driver.getTitle(), "Login");
     }
     
    	 //login
    	
       Assert.assertEquals(driver.getTitle(), "Login");
       System.out.println("Testmeapp opened");
       driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
       
        
        //driver.findElement(By.linkText("SignIn")).click();
        //Assert.assertEquals(driver.getTitle(), "Login");
        driver.findElement(By.name("userName")).sendKeys("lalitha");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@name='Login'] ")).click();
        Assert.assertEquals(driver.getTitle(), "Home");   
       //addcart
        driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();//all categories
       //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
       Actions act=new Actions(driver);
       act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"))).build().perform();
       System.out.println("success");
       driver.findElement(By.linkText("Electronics")).click();
       
       //WebDriverWait wait=new WebDriverWait(driver,100);
       //wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("HeadPhone")));
       driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click();
       Assert.assertEquals(driver.getTitle(), "Search");   
       //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
       driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();//headphone
       Assert.assertEquals(driver.getTitle(), "Search");  
       //driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
       Assert.assertEquals(driver.getTitle(), "View Cart");
         //payment
        Assert.assertEquals(driver.getTitle(), "View Cart"); 
         driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
         Assert.assertEquals(driver.getTitle(), "Cart Checkout");
          driver.findElement(By.name("ShippingAdd")).sendKeys("mysuru");
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
  




 /*@Test
  public void failTest() {
   logger = extent.startTest("failTest");
   driver = BrowserClass.openBrowser("firefox");
   driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
   String title = driver.getTitle();
   Assert.assertEquals(title, "NoTitle");
   logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
  }




 @Test
  public void skipTest() {
   logger = extent.startTest("skipTest");
   throw new SkipException("Skipping - This is not ready for testing ");
  }*/




 @AfterMethod
  public void getResult(ITestResult result) throws Exception {
   if (result.getStatus() == ITestResult.SUCCESS) {
    logger.log(LogStatus.PASS, "Test Case Failed is " + result.getName());
    logger.log(LogStatus.PASS, "Test Case Failed is " + result.getThrowable());
    String screenshotPath = reports.getScreenshot(driver, result.getName());
    logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
   } else if (result.getStatus() == ITestResult.SKIP) {
    logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
   }
   extent.endTest(logger);
  }




 @AfterTest
  public void endReport() {
   extent.close();
   driver.close();
  }
}