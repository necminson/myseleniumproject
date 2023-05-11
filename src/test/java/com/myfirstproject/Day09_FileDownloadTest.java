package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.myfirstproject.utilities.ThreadSleepUtil.waitUpTo;
//Create a class:FileDownloadTest

public class Day09_FileDownloadTest extends TestBase {
            //In the downloadTest() method, do the following test:
    @Test
    public void downloadTest(){
        //https://testcenter.techproeducation.com/index.php?page=file-download
            driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //Download b10 all test cases, code.docx file // b10 all test cases, code.docx
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitUpTo(2000);
        //Then verify if the file downloaded successfully
        String filePath = System.getProperty("user.home")+"\\Downloads\\b10 all test cases, code.docx";
         Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }


}
