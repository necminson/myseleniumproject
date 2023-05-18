package com.myfirstproject.day09;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Class Name: FileUploadTest
   public class Day09_FileUpload extends TestBase {
            //Method Name: fileUploadTest

     @Test
    public void fileUploadTest(){
         //When user goes to https://the-internet.herokuapp.com/upload
         driver.get("https://the-internet.herokuapp.com/upload");
        //When user selects an image from the desktop
         String filePath = System.getProperty("user.home")+"\\Downloads\\b10 all test cases, code.docx";
         driver.findElement(By.id("file-upload")).sendKeys(filePath);

        //And click on the upload button
         driver.findElement(By.id("file-submit")).click();
        //Then verify the File Uploaded!  Message displayed
         Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h3")).isDisplayed());

     }
    @Test  // Ahmet Instructor's typing
    public void fileUploadTest01(){
        /*
        We use sendkeys functions to upload files if the html is INPUT TYPE=FILE
        If other element is used to upload files, then we can use ROBOT class in JAVA
         */
        //    When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
//        to upload a file to this type of element, we should send the path of the file to the input
//        element is TAG = INPUT, TYPE = FILE
//        locate the chose a file element, get the path of teh file, then use send keys function
//    When user selects an image from the desktop
        WebElement chooseAFile=driver.findElement(By.id("file-upload"));
        String pathOfFlower = System.getProperty("user.home")+"/Desktop/flower.jpeg";
//        String pathOfFlower = userHome+"\\Desktop\\flower.jpeg";//WINDOWS
        chooseAFile.sendKeys(pathOfFlower);
//    And click on the upload button
        driver.findElement(By.id("file-submit")).click();
//    Then verify the File Uploaded!  Message displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h3")).isDisplayed());
    }
}

