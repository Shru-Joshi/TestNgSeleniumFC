package Library;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AutoTasks {
	
	public static String[] updateProfile(WebDriver driver) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		CreateReference.createReference();
		String[] result =  new String[2];
		result[0]="Update Profile";
		System.out.println("Updating Password");
		
		driver.findElement(By.xpath("//li/a[contains(text(),'Profile')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='currentPassword']")).sendKeys(CreateReference.t1.get("Password"));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='newPassword']")).sendKeys(CreateReference.t1.get("NewPassword"));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='newPasswordConfirmation']")).sendKeys(CreateReference.t1.get("NewPassword"));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(3000);
		
		String expectedTitle = "The profile has been saved successful";
		 
        // fetch the title of the web page and save it into a string variable
		driver.findElement(By.xpath("//div[contains(@class,'result alert alert')]")).isDisplayed();
        String actualTitle = driver.findElement(By.xpath("//div[contains(@class,'result alert alert')]")).getText();
        // compare the expected title of the page with the actual title of the page and print the result
        if (expectedTitle.equals(actualTitle))
        {
               System.out.println("Good Password - Profile Updated, password changed");

        }
        else
        {
        		System.out.println("Bad Password, "+actualTitle);
        }
        result[1]=actualTitle;
		return result;

	}
	
	public static String[] popularMake(WebDriver driver) throws InterruptedException, IOException {
		String[] result =  new String[2];
		//find the element that gives us the popular make
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Popular Make')]/..//div[@class='card-block']/h3"));	
		result[0]="Popular Make";
		result[1]=element.getText();
		System.out.println("Popular Make " + element.getText());
		return(result);
	}
	
	public static String[] popularModel(WebDriver driver) throws InterruptedException, IOException {
		String[] result =  new String[2];
		//find the element that gives us the popular model
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Popular Model')]/..//div[@class='card-block']/h3"));
		result[0]="Popular Model";
		result[1]=element.getText();
		System.out.println("Popular Model " + element.getText());
		return(result);
	}
	
	public static String[] overallRate(WebDriver driver) throws InterruptedException, IOException {
		String[] result =  new String[7];
		result[0]="Rank No. 1";
		System.out.println("Rank No. 1");

		driver.findElement(By.xpath("//a[@href='/overall']")).click();
		Thread.sleep(10000);
		WebElement parent=driver.findElement(By.xpath("//table[@class='cars table table-hover']//tbody"));
		WebElement rank1=parent.findElement(By.xpath("//tr[1]"));
		rank1.click();
		List<WebElement> elems =rank1.findElements(By.xpath("//td"));
		if(elems.size()>0) {
			for(int i=0;i<=5;i++) {
				if(i>=1) {	
					String myText = elems.get(i).getText();
			        System.out.print(myText+"\t");
					result[i]=myText;
				}
			}
		}
		System.out.println();

		return result;
		
		/*List<WebElement> elements=parent.findElements(By.xpath("//tr"));
        Iterator<WebElement> it = elements.iterator();
        while(it.hasNext()) {
        	List<WebElement> elems =it.next().findElements(By.xpath("//td"));
			if(elems.size()>0) {
				for(int i=0;i<=5;i++) {
					if(i>=1) {	
						String myText = elems.get(i).getText();
				        System.out.print(myText+"\t");
					}
				}
			}
			System.out.println();
        }*/
	}

}
