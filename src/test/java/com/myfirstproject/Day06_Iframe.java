package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day06_Iframe extends TestBase {

    //    https://testcenter.techproeducation.com/index.php?page=iframe
//    click on the Back to TechProEducation.com
    @Test
    public void iframeTest() throws InterruptedException {
//        going to the page
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");


//        the element is INSIDE THE IFRAME SO SWITCH THE FRAME FIRST
        /*
        NOTE: I have to switch to the frame otherwise I will get no such element exception when
        I try to locate button
        When I switch to the frame I will locate the element and wil not get no such element exception
         */
        driver.switchTo().frame(0);
        Thread.sleep(2000);
//        location the element inside the frame and trying to click
        WebElement element = driver.findElement(By.xpath("//a[@type='button']"));
        Thread.sleep(2000);

//        NOTE: NORMAL CLICK DIDN'T WORK I USED JS EXECUTOR YOU WILL LEARN THIS LATER
//        element.click(); UNFORTUNATELLY DIDN'T WORK

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);


    }
}
