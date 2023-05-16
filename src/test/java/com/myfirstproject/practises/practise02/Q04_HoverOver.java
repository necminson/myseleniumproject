package com.myfirstproject.practises.practise02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class Q04_HoverOver extends TestBase {

    @Test
    public void Test(){
     //Go to https://www.gmibank.com/
        driver.get("https://www.gmibank.com");
     //Hover over "Premium" Deposit Package
       WebElement premium = driver.findElement(By.xpath("//h4[.='Premium']"));
       new Actions(driver).moveToElement(premium).perform();
     //Click on "Book Now"
        driver.findElement(By.xpath("(//a[.='Book Now'])[2]")).click();
     //Verify url contains "services"
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("services"));

    }
}
