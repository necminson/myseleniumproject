package com.myfirstproject.practises.practise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.myfirstproject.utilities.ThreadSleepUtil.waitUpTo;


public class Q01_Navigations {
// ...Practice 1...
// Set Driver Path
// Create chrome driver object
// Maximize the window
// Open google home page https://www.google.com/
// Navigate to techproeducation home page https://techproeducation.com/
// Navigate back to google
// Navigate forward to techproeducation
// Refresh the page
// Close/Quit the browser
// And last step : print "ALL OK" on console
   @Test
    public void Practice01(){
       // Set Driver Path
       WebDriverManager.chromedriver().setup();
       // Create chrome driver object
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       // Maximize the window
       driver.manage().window().maximize();
       // Open google home page https://www.google.com/
       driver.get("https://www.google.com/");
       waitUpTo(2000);
       // Navigate to techproeducation home page https://techproeducation.com/
       waitUpTo(2000);
       driver.navigate().to("https://techproeducation.com/");
       // Navigate back to google
       waitUpTo(2000);
       driver.navigate().back();
       // Navigate forward to techproeducation
       waitUpTo(2000);
       driver.navigate().forward();
       // Refresh the page
       waitUpTo(2000);
       driver.navigate().refresh();
       // Close/Quit the browser
       driver.close();
       // And last step : print "ALL OK" on console
       System.out.println("ALL OK");


   }


}
