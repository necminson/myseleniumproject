package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day05_RadioButton extends TestBase {
    /*
    https://testcenter.techproeducation.com/index.php?page=radio-buttons
    Click on Red
        Click on Football
     */
    @Test
    public void radioButtonTest(){
        // go to url
        driver.get(" https://testcenter.techproeducation.com/index.php?page=radio-buttons");
        //        locating red
        WebElement red = driver.findElement(By.id("red"));
//        clicking on red
        red.click();
//        verifying if red is checked
        Assert.assertTrue(red.isSelected());
// Click on Football in 2 mins
        WebElement football = driver.findElement(By.id("football"));
        football.click();
        Assert.assertTrue(football.isSelected());

    }
}
