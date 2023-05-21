package com.myfirstproject.practises.Practise03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Q01_Clicks extends TestBase {

    @Test
    public void clickTest(){
        // Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
            driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        // Click all the buttons
            driver.findElement(By.id("onblur")).click();
            driver.findElement(By.id("onclick")).click();// This click will be  used for first "onblur" button
            driver.findElement(By.id("onclick")).click();// This click will be  used for "onclick" button

        WebElement onContextMenu = driver.findElement(By.id("oncontextmenu"));
        WebElement ondoubleclick = driver.findElement(By.id("ondoubleclick"));
        WebElement onfocus = driver.findElement(By.id("onfocus"));
        WebElement onkeydown = driver.findElement(By.id("onkeydown"));
        WebElement onkeyup = driver.findElement(By.id("onkeyup"));
        WebElement onkeypress = driver.findElement(By.id("onkeypress"));
        WebElement onmouseover = driver.findElement(By.id("onmouseover"));
        WebElement onmouseleave = driver.findElement(By.id("onmouseleave"));
        WebElement onmousedown = driver.findElement(By.id("onmousedown"));


        new Actions(driver).pause(Duration.ofSeconds(1)).contextClick(onContextMenu)
                           .pause(Duration.ofSeconds(1)).doubleClick(ondoubleclick)
                           .pause(Duration.ofSeconds(1)).click(onfocus)
                           .pause(Duration.ofSeconds(1)).click(onkeydown).sendKeys(Keys.SPACE)
                           .pause(Duration.ofSeconds(1)).click(onkeyup).sendKeys(Keys.SPACE)
                         //.pause(Duration.ofSeconds(1)).click(onkeyup).keyDown(Keys.SPACE).pause(Duration.ofSeconds(5)).keyUp(Keys.SPACE)
                           .pause(Duration.ofSeconds(1)).click(onkeypress).sendKeys(Keys.SPACE)
                           .pause(Duration.ofSeconds(1)).moveToElement(onmouseover)
                           .pause(Duration.ofSeconds(1)).moveToElement(onmouseleave).pause(Duration.ofSeconds(1)).click(onmousedown)//
                           .pause(Duration.ofSeconds(1)).click(onmousedown)
                           .perform();

        // Assert all buttons clicked
               int numOfTriggeredEvents =  driver.findElements(By.xpath("//p[.='Event Triggered']")).size();
               assertEquals(11,numOfTriggeredEvents);

    }


}
