package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.myfirstproject.utilities.ThreadSleepUtil.threadSleepUtil;

public class Day07_WindowHandle1 extends TestBase {

    @Test
    public void windowHandleTest(){

        // Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        // Then user verifies the text : “Opening a new window”
        String actualPage1HeaderText = driver.findElement(By.xpath("//h3")).getText();
        String expectedPage1HeaderText = "Opening a new window";
        Assert.assertEquals(expectedPage1HeaderText,actualPage1HeaderText);

        // Then user verifies the title of the page is “The Internet”
        String actualTitlePage1 = driver.getTitle();
        String expectedTitlePage1 = "The Internet";
        Assert.assertEquals(expectedTitlePage1,actualTitlePage1);

        // When user clicks on the “Click Here” button
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        // Then user verifies the new window title is “New Window”
                //     LET's GET WINDOW 1 HANDLE FIRST CAUSE WE MAY NEED TO SWITCH BACK TO WINDOW 1
                        String window1Handle = driver.getWindowHandle();
                        System.out.println(window1Handle);
                //     DRIVER IS STILL ON WINDOW 1
                        Set<String> allWindowHandles = driver.getWindowHandles();
                        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles) {
            if (!eachHandle.equals(window1Handle)){// if we are not on window1, then MUST BE on window2,then switch to window2
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        String actualTitlePage2 = driver.getTitle();
        String expectedTitlePage2 = "New Window";
        Assert.assertEquals(actualTitlePage2,expectedTitlePage2);
        // Then user verifies the text:  “New Window”
        String actualPage2Text = driver.findElement(By.xpath("//h3")).getText();
        String expectedPage2Text = "New Window";
        Assert.assertEquals(actualPage2Text,expectedPage2Text);

                //      DRIVER IS ON 2nd WINDOW AS OF NOW
                        String window2Handle = driver.getWindowHandle(); // we can use this window2Handle if we want to switch back to this window

        // When user goes back to the previous window and then verifies the title : “The Internet”
        String actualTitlePage01 = driver.switchTo().window(window1Handle).getTitle(); // switching the window1 and getting the title
        String expectedTitlePage01 = "The Internet";
        Assert.assertEquals(actualTitlePage01,expectedTitlePage01);
        threadSleepUtil(5000);

        // SWITCH BACK TO WINDOW 2
           driver.switchTo().window(window2Handle);
           threadSleepUtil(5000);

        // SWITCH BACK TO WINDOW 1
        driver.switchTo().window(window1Handle);
        threadSleepUtil(5000);

        // SWITCH BACK TO WINDOW 2
        driver.switchTo().window(window2Handle);
        threadSleepUtil(5000);
    }
}
