package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.myfirstproject.utilities.ThreadSleepUtil.waitFor;

public class Day05_Dropdown extends TestBase {
    @Test
    public void selectByIndexTest(){

        //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //1.Create method selectByIndexTest and Select Option 1 using index
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdown);
        options.selectByIndex(1);


    }
    @Test
    public void selectedByValueTest(){
        //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //2.Create method selectByValueTest Select Option 2 by value
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdown);
        options.selectByValue("2");

    }

    @Test
    public void selectByVisibleTextTest(){
        //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //3.Create method selectByVisibleTextTest Select Option 1 value by visible text
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdown);
        options.selectByVisibleText("Option 1");
        waitFor(3000);
        options.selectByVisibleText("Option 2");
        waitFor(3000);
        options.selectByVisibleText("Option 1");
        waitFor(3000);
        options.selectByVisibleText("Option 2");


    }
    @Test
   public void printAllTest(){
        //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //4.Create method printAllTest Print all states value
        WebElement state = driver.findElement(By.id("state"));
        Select options = new Select(state);
        List<WebElement> allStates = options.getOptions();
        for ( WebElement eachState:allStates) {
            System.out.println("eachState.getText() = " + eachState.getText());
        }
        //5. Verify the dropdown has Texas text

        boolean isTexasExist = false;
        for (WebElement eachStates:allStates ) {
            if (eachStates.getText().equals("Texas")){
                isTexasExist=true;
            }
        }
        Assert.assertTrue(isTexasExist);
    }
        @Test
        public void printFirstSelectedOptionTest(){
            //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
            //6.Create method printFirstSelectedOptionTest Print first selected option
            WebElement state = driver.findElement(By.id("state"));
            Select options = new Select(state);
            String firstSelectedOption = options.getFirstSelectedOption().getText();
            System.out.println("firstSelectedOption = " + firstSelectedOption);

            //7.Find the size of the States,
            //Print "Expected Is Not Equal Actual" if there are not 3 elements in the States.
            int numberOfOptions = options.getOptions().size();
            Assert.assertEquals("Expected Is Not Equal Actual",3,numberOfOptions);
        }

}
