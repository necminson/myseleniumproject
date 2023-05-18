package com.myfirstproject.day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions1 extends TestBase {

    @Test
    public void contextClickTest(){

        //Given user is on the https://testcenter.techproeducation.com/index.php?page=context-menu
        driver.get("https://testcenter.techproeducation.com/index.php?page=context-menu");
        //When use Right clicks on the box
        WebElement elementBox = driver.findElement(By.id("hot-spot")); // find the box element
        Actions actions = new Actions(driver); // Create actions object
        actions.contextClick(elementBox).perform(); // right click on the box

        //Then verify the alert message is “You selected a context menu”
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";
        Assert.assertEquals(expectedAlertText,actualAlertText);
        //Then accept the alert
        driver.switchTo().alert().accept();

    }
    @Test // Ahmet Instructor's typing
    public void contextClickTest01(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=context-menu");
//        When use Right clicks on the box
        WebElement box = driver.findElement(By.id("hot-spot"));
//        Creating Actions Class
        Actions actions = new Actions(driver);//creating Actions object
        actions.contextClick(box).perform();//right click on the box
//        Then verify the alert message is “You selected a context menu”
        Assert.assertTrue(driver.switchTo().alert().getText().equals("You selected a context menu"));
//        Then accept the alert
        driver.switchTo().alert().accept();

    }

}
