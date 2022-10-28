package com.funnygorilla;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main (String []args) {
   	 
   	 
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
	    //Launch website
	    driver.navigate().to("http://www.calculator.net/");
      
        //Maximize the browser
        driver.manage().window().maximize();
        
//        String title = driver.getTitle();
//        System.out.println("-------> " + title);
        System.out.println("------->\n" + driver.getPageSource());
      
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
      
        //Close the Browser.
        //driver.close();
	 
		
 }
}
