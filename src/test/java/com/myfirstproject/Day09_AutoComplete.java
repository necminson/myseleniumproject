package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.myfirstproject.utilities.ThreadSleepUtil.waitUpTo;

public class Day09_AutoComplete extends TestBase {

    @Test
    public void autoCompleteTest(){
        //Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        //When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        waitUpTo(2000);
        //And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//*[.='United Kingdom']")).click();
        //And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
        waitUpTo(2000);
        //Then verify the result contains ‘United Kingdom’
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));

    }


}
