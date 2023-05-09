package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
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
//        driver.switchTo().frame(0);//1. switching to the first frame by index
//         driver.switchTo().frame("name or id of the frame element");//2. SKIP cause there is no id or name of the frame
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src='/index.php']"));
        driver.switchTo().frame(frameElement);//3. switching the frame element by locating the frame

    // AT THIS POINT DRIVER IS INSIDE THE FRAME

        Thread.sleep(2000);
//        location the element inside the frame and trying to click
        WebElement element = driver.findElement(By.xpath("//a[@type='button']"));
        Thread.sleep(2000);
//        NOTE: NORMAL CLICK DIDN'T WORK I USED JS EXECUTOR YOU WILL LEARN THIS LATER
//        element.click(); UNFORTUNATELLY DIDN'T WORK
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);


 // Assert if h3 element's text is equal to "iframe"
 //  STILL INSIDE THE FRAME. DRIVER MUST SWITCH BACK TO PARENT FRAME OR DEFAULT CONTENT
        // BECAUSE THE ELEMENT IS NOT IN THE FRAME
        // driver.switchTo().parentFrame(); // go to the parent frame
        driver.switchTo().defaultContent();// alternatively we can switch to default page
        String actualHeaderText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("iframe",actualHeaderText);

    }
}
