package com.myfirstproject.day06;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day06_dynamic_xpath extends TestBase {


    @Test
    public void dynamicXpath(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       String userNameText = driver.findElement(By.xpath("//p[text()='Username : Admin']")).getText();
       String expectedText = "Username : Admin";
       Assert.assertEquals(expectedText,userNameText);

       driver.findElement(By.xpath("//*[contains(@name,'username')]")).sendKeys("Admin");
       driver.findElement(By.xpath("//*[contains(@type,'passwor')]")).sendKeys("admin123");
       driver.findElement(By.xpath("//*[contains(@type,'submit')]")).submit();


    }
    @Test
    public void dynamicXpath02(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //        location Username : Admin element and doing assertion
        //        //tag[text()='full visible text of the element']
        //        //tag[contains(text(),'full or partial text of the element')] -> didn't work this time
        //        //tag[.='full visible text of the element']
        String userNameText = driver.findElement(By.xpath("//p[text()='Username : Admin']")).getText();
        Assert.assertEquals("Username : Admin",userNameText);
        //Alternatively
        //        WebElement userName =  driver.findElement(By.xpath("//p[text()='Username : Admin']"));
        //        Assert.assertEquals("Username : Admin",userName.getText());
        //        //tag[contains(@attr,'partial or full value of that attribute')]
        driver.findElement(By.xpath("//input[contains(@name,'sernam')]")).sendKeys("Admin");
        //        //tag[@att1='value' and @attr1 = 'value']
        driver.findElement(By.xpath("//input[@type='password' and @placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
    }
}
