package com.myfirstproject.practises.practise01.practise02;

import com.myfirstproject.utilities.TestBase;

import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.ListResourceBundle;

public class Q06_DeleteAndDragBack extends TestBase{

    @Test
    public void Test(){

         //Go to URL : https://www.globalsqa.com/demo-site/draganddrop/
         driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        // Switch to frame
        WebElement iframe = driver.findElement(By.xpath("//iframe[@data-src='../../demoSite/practice/droppable/photo-manager.html']"));
        driver.switchTo().frame(iframe);
         //Delete images by clicking delete buttons
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[.='Delete image']"));
        //        for (WebElement w : deleteButtons) {
//            Thread.sleep(1000);
//            w.click();
//        }

        deleteButtons.forEach(WebElement::click);//Lambda is recommended

//        Recycle images by clicking Recycle buttons
        List<WebElement> recycleButtons = driver.findElements(By.xpath("//a[.='Recycle image']"));
        recycleButtons.forEach(WebElement::click);

//        Delete images by drag and drop
       List<WebElement> images = driver.findElements(By.xpath("//ul[@id='gallery']/li"));
        Actions actions = new Actions(driver);
        WebElement trash = driver.findElement(By.id("trash"));
        images.forEach(t->actions.pause(1000).dragAndDrop(t,trash).perform());
//        Recycle images by drag and drop
        WebElement gallery = driver.findElement(By.id("gallery"));
        images.forEach(t->actions.pause(1000).dragAndDrop(t,gallery).perform());
    }
}
