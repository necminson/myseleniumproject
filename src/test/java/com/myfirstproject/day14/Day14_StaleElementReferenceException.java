package com.myfirstproject.day14;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.myfirstproject.utilities.WaitForUtils.*;

public class Day14_StaleElementReferenceException extends TestBase {

    @Test
    public void staleElementReferenceExceptionTest01(){

        driver.get("https://testcenter.techproeducation.com/");
        //and click on checkbox link
        WebElement checkboxesLink= driver.findElement(By.linkText("Checkboxes"));

        //Refresh
        driver.navigate().refresh();
        checkboxesLink.click();//StaleElementReferenceException

    }

    @Test
    public void staleElementReferenceExceptionTest02(){
        driver.get("https://testcenter.techproeducation.com/");
        //and click on checkbox link
        WebElement checkboxesLink= driver.findElement(By.linkText("Checkboxes"));
        checkboxesLink.click();

        waitFor(5000);
        driver.navigate().back();
        waitFor(5000);
        checkboxesLink.click();
    }

    @Test
    public void staleElementReferenceExceptionTest3(){
        driver.get("https://www.amazon.com/");
        WebElement registry = driver.findElement(By.xpath("//*[@id='nav-xshop']//a[3]"));
        registry.click();
        waitFor(5);
        driver.navigate().back();
        waitFor(5);
        registry.click();
    }
}
