package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day11_ExtentReportsScreenshot extends TestBase {

    @Test
    public void extentsReportsScreenshotTest() throws Exception {
        //        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
//        When user type “uni” in the search box
        extentTest
                .pass("Taking the screenshot of the home page")
                .assignDevice("Windows","Chrome")
                .assignCategory("Smoke","Regression","Integration")
                .assignAuthor("Rufat","Necmettin","Neslihan")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        //TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        Thread.sleep(2000);
//        And select the ‘United Kingdom’ from the suggestions
        //TAKE SCREENSHOT
        extentTest
                .pass("Selecting the United Kingdom option")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        takeScreenshotOfTheEntirePage();
//        TAKING SCREENSHOT OF ONLY UNITED KINGDOM ELEMENT
        takeScreenshotOfThisElement(driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//*[.='United Kingdom']")));
        driver
                .findElement(By.xpath("//div[@id='myCountryautocomplete-list']//*[.='United Kingdom']"))
                .click();
        Thread.sleep(2000);
//        And click on submit button
        //TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();
        extentTest
                .pass("Clinking on the Submit Button")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(2000);
        //TAKE SCREENSHOT
//        Then verify the result contains ‘United Kingdom’
        takeScreenshotOfTheEntirePage();
//        TAKING THE SCREENSHOT OF THE RESULT ELEMENT
        extentTest
                .pass("Taking the screenshot of result element")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        WebElement result = driver.findElement(By.id("result"));
        takeScreenshotOfThisElement(result);
        extentTest
                .pass("Asserting the result contains United Kingdom")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
    }
}
