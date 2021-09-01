package InvokeLayer;

import org.testng.annotations.Test;

import Library.AutoTasks;
import Library.CreateReference;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class BuggyRatingTest {
	
	static WebDriver driver;
	String[] result1=  new String[2];
	String[] result2=  new String[2];
	String[] result3=  new String[2];
	String[] result4=  new String[2];
	String[] result5=  new String[2];
	String[][] result = new String[5][7];

  @Test
  public void functionalTest()  throws InterruptedException, IOException {
	  CreateReference.createReference();
	  driver.findElement(By.xpath("//input[@name='login']")).sendKeys(CreateReference.t1.get("UserId"));
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(CreateReference.t1.get("Password"));
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
	  Thread.sleep(3000);
	  
	  if(driver.findElements(By.xpath("//li/a[contains(text(),'Logout')]")).size()>0) {
		  	result1[0]="Successfully Logged In";
			WebElement element=driver.findElement(By.xpath("//*[@class='nav-link disabled']"));
			result1[1] = element.getText();
			System.out.println("Login Verification" + Arrays.toString(result1));

			result2 =AutoTasks.popularMake(driver);
			result3 =AutoTasks.popularModel(driver);
			result4 =AutoTasks.overallRate(driver);
			result5 =AutoTasks.updateProfile(driver);		
			
			result[0][0]=result1[0];
			result[0][1]=result1[1];
			result[1][0]=result2[0];
			result[1][1]=result2[1];
			result[2][0]=result3[0];
			result[2][1]=result3[1];
			result[3][0]=result4[0];
			result[3][1]=result4[1];
			result[3][2]=result4[2];
			result[3][3]=result4[3];
			result[3][4]=result4[4];
			result[3][5]=result4[5];
			result[4][0]=result5[0];
			result[4][1]=result5[1];
			
			driver.findElement(By.xpath("//li/a[contains(text(),'Logout')]")).click();
	  }
	  else {
			result1[0]="Login Failed";
			WebElement elem=driver.findElement(By.xpath("//span[@class='label label-warning']"));
			result1[1] = elem.getText();
			System.out.println("Login Verification" + Arrays.toString(result1));
			result[0][0]=result1[0];
			result[0][1]=result1[1];
	  }
		
	  CreateReference.outPut(result);
  }
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  
	  String driverPath=System.getProperty("user.dir")+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		 	options.addArguments("test-type");
		    options.addArguments("start-maximized");
		    options.addArguments("--js-flags=--expose-gc");  
		    options.addArguments("--enable-precise-memory-info"); 
		    options.addArguments("--disable-popup-blocking");
		    options.addArguments("--disable-default-apps"); 
		    options.addArguments("disable-infobars"); 
		    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		    options.addArguments("--disable-extensions");
		    options.addArguments("--safebrowsing-disable-download-protection");
		    options.addArguments("safebrowsing-disable-extension-blacklist");
		    options.setExperimentalOption("useAutomationExtension", false);
		    options.addArguments("disable-geolocation");
		
		driver = new ChromeDriver(options);
		driver.get("https://buggy.justtestit.org/");
		Thread.sleep(5000);
		
  }

  @AfterMethod
  public void afterMethod() {
		driver.close();
  }

}
