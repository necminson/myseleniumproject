package com.myfirstproject.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_xpath_css {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        // When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void loginTest(){
        //And enter username
       WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
       username.sendKeys("Admin");

       //And enter password
      WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
      password.sendKeys("admin123");

      //And click on submit button
     WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
     loginButton.submit();

    }
    @Test
   public void loginTest02(){
       // username
       driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");

       //password
       driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");

       //login button
       driver.findElement(By.cssSelector("button[type='submit']")).click();

   }

}
