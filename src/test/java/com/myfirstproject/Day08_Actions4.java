package com.myfirstproject;
        //Create a class: Day08_Actions4

import com.myfirstproject.utilities.TestBase;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.myfirstproject.utilities.ThreadSleepUtil.waitUpTo;

public class Day08_Actions4 extends TestBase {
        //Create a method dragAndDropTest
    @Test
    public void dragAndDropTest(){
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        // First we should go in to frame
        /*
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameElement);
         */
        driver.switchTo().frame(0); // we know tha there is one frame
        waitUpTo(3000);
        // Then drag and drop
        WebElement sourceElement = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement targetElement = driver.findElement(By.xpath("//*[@id='droppable']"));
            // we will use move the sourceElement in the targetElement, so we should use Actions Class
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement,targetElement).perform();
    }
    @Test
    public void dragAndDropByTest(){
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(source,159,22).perform();

    }
    @Test
    public void clickAndHoldTest(){
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).build().perform();

    }
}

