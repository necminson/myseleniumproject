package com.myfirstproject.day14;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;


import static com.myfirstproject.utilities.WaitForUtils.*;

public class Day14_TimeOutException extends TestBase {
    @Test
    public void noSuchElementExceptionTest1(){
        driver.get("https://www.amazon.com");
        /*
         *when driver can not locate the element even after explicit wait, then we see timeoutexception
         * max time may not be enough. increase timeout OR TRY FOLLOWING
         * SOLUTION:
         * 1. CHECK LOCATOR. CHECK SYNTAX.
         * 2. CHECK FRAMES, NEW WINDOWS, ALERTS, POP UPS, HTML ELEMENT THAT MIGHT NOT BE DISPLAYED
         * 3. DO MANUAL TEST TO COMPLETELY UNDERSTAND THE STEPS. DO CHECK YOU TEST STEPS. YOUR LOGIC AND TEST EXECUTION FLOW SHOULD BE GOOD
         */
//        USE EXPLICIT WAIT
        explicitlyWaitFor_id("twotabsearchtextbox ",15);
        // driver.findElement(By.id("twotabsearchtextbox ")); // TimeoutException
                                // cause after explicit wait time, element is not still found
        //driver.findElement(By.name("twotabsearchtextbox")); // TimeoutException

//        Question: if you use explicit wait and that step fails what kind of exception do you get?
//        Answer  : timeout
//        NOTE: waitForVisibility(WebElement element ,15); throws NoSuchElementException
//          BUT waitForVisibility(By by ,15); throws TimeOutException
//        NOTE: When we use driver with explicit wait, we get no such element exception otherwise timeout exception
//        CASE 1
        explicitlyWaitForVisibility(driver.findElement(By.name("twotabsearchtextbox")),15);
        //1. Explicit wait
        //2. Failing
        //3. Using driver in the explicit wait:
        //4. Getting : NoSuchElementException
//       CASE 2
        explicitlyWaitForVisibility(By.id("wrong-fake-id"),25);
        //1. Explicit wait
        //2. Failing
        //3. Not using driver in the explicit wait
        //4. TimeoutException
    }

    }


