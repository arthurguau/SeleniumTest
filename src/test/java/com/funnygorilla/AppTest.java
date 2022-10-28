package com.funnygorilla;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
	
	private WebDriver driver; 
	String appURL = "http://google.com";

	public AppTest( String testName ){
        super( testName );
    }

    @BeforeClass
	public void testSetUp() {
	}

   @Test
    public void testApp(){
      	System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
		driver.navigate().to(appURL);
		String getTitle = driver.getTitle();
		System.out.println(" =================> " + getTitle);
		
		Assert.assertEquals(getTitle, "Google");
		
		driver.quit();
    }
   
   @Test
   public void testWebSite() {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

       //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
	    //Launch website
	    driver.navigate().to("http://www.calculator.net/");
     
       //Maximize the browser
       driver.manage().window().maximize();

       // Click on Math Calculators
       driver.findElement(By.xpath(".//div[@id = 'contentout']//*[text()='7']")).click();
       driver.findElement(By.xpath(".//div[@id = 'contentout']//*[text()='+']")).click();
       driver.findElement(By.xpath(".//div[@id = 'contentout']//*[text()='8']")).click();
       // Get the Result Text based on its xpath
       String result = driver.findElement(By.xpath("//div[@id = 'sciOutPut']")).getText();

       int expectedResult = 15;
       // Print a Log In message to the screen
       System.out.println(" The Result is: [" + result + "]  Exoected result is: [" + expectedResult + "]");
       
       Assert.assertEquals (Integer.parseInt(result.trim()), expectedResult);
       
       driver.quit();
   }

    @AfterClass
	public void tearDown() {
	}

}
