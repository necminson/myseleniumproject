package com.myfirstproject.practises.Practise03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public class Q02_FileUpLoad extends TestBase {

    @Test
    public void fileUpLoadTest(){
        //  Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
            driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        // Type "My File" into "Notes about the file" input
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("My File");
        // Click "Choose File" button
        //  Select the file to upload
        //driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\necme\\OneDrive\\Desktop\\text.txt");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.home")+"\\OneDrive\\Desktop\\text.txt");
        //  Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //  Assert that "Your notes on the file were" equals "My File"
            String note = driver.findElement(By.xpath("//blockquote")).getText();
            assertEquals("My File",note);
        //  Assert that file Content contains "Hello, I am uploaded file"
        String fileContent = driver.findElement(By.className("pre")).getText();
        assertEquals("Hello, I am uploaded file",fileContent);
    }


}
