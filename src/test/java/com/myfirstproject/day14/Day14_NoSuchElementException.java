package com.myfirstproject.day14;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day14_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementExceptionTest1(){
        driver.get("https://www.amazon.com");
        /*
                *WRONG LOCATORS CAUSES NO SUCH ELEMENT EXCEPTION
                * FRAMES,WINDOWS,ALERTS,HIDDEN ELEMENTS CAUSE NO SUCH ELEMENT EXCEPTION
                * IN SHORT, IF THE ELEMENT IS NOT FOUND ON THE PAGE WE GET NO SUCH ELEMENT EXCEPTION
         * SOLUTION:
         * 1. CHECK LOCATOR. CHECK SYNTAX.
         * 2. CHECK FRAMES, NEW WINDOWS, ALERTS, POP UPS, HTML ELEMENT THAT MIGHT NOT BE DISPLAYED
         * 3. DO MANUAL TEST TO COMPLETELY UNDERSTAND THE STEPS. DO CHECK YOU TEST STEPS. YOUR LOGIC AND TEST EXECUTION FLOW SHOULD BE GOOD
         */
       // driver.findElement(By.id("twotabsearchtextbox ")); // NoSuchElementException
        //driver.findElement(By.name("twotabsearchtextbox")); // NoSuchElementException

    }
}
