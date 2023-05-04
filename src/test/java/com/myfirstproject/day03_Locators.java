package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.myfirstproject.utilities.ThreadSleepUtil.threadSleepUtil;

public class day03_Locators {
    /*
      Create a class: Locators
      When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
      And enter username
      And enter password
      And click on submit button
      Then verify the login is successful
      Then logout the application
      Then verify the logout is successful

     */
    WebDriver driver;
    @Before
    public void setUp(){
//      this method will be used for precondition
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @After
    public void tearDown(){
     //  this method will be used for after conditions
      driver.quit();
    }
    @Test
    public void loginTest()  {
//        locating username
       driver.findElement(By.name("username")).sendKeys("Admin");
       //        locating password
        driver.findElement(By.name("password")).sendKeys("admin123");
//        locating button
        driver.findElement(By.tagName("button")).click();

//          Then verify the login is successful
        String actualURL = driver.getCurrentUrl();
        String expectedKeyword = "dashboard";

//        Then verify the login is successful
        Assert.assertTrue(actualURL.contains(expectedKeyword));

//        putting hard wait. this is a JAVA wait. i want to wait for 3 seconds
        threadSleepUtil(3000);

        //Thread.sleep(3000);

//        locating the menu
        driver.findElement(By.className("oxd-userdropdown-tab")).click();
//        putting hard wait
        threadSleepUtil(3000);
        //Thread.sleep(3000);
//        locating logout option
        driver.findElement(By.linkText("Logout")).click();
//        Then verify the logout is successful
        Assert.assertTrue(driver.findElement(By.xpath("//h5[@class=\"oxd-text oxd-text--h5 orangehrm-login-title\"]")).isDisplayed());
    }

}
