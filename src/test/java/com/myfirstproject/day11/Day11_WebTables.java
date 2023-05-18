package com.myfirstproject.day11;

import com.myfirstproject.utilities.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

//Create a class: WebTables
public class Day11_WebTables extends TestBase {

    private static Logger logger = LogManager.getLogger(Day11_WebTables.class.getName());
    @Test
    public void printTable(){
        //    Task 1 : Print the entire table
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.pass("******PRINT ENTIRE TABLE****");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
       logger.info("TABLE 1 DATA");
        System.out.println(entireTable);
//        ALTERNATIVELY
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachData : elements){
            System.out.println(eachData.getText());
            extentTest.pass(eachData.getText());
        }
//        GET SPECIFIC INDEXED ELEMENTS
        System.out.println("6TH DATA IN THE TABLE =>>> "+elements.get(5).getText());
    }
    //    Task 2 : Print All Rows
    @Test
    public void printAllRows(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        int rowNum=1;
        for (WebElement eachRow : allRows){
            System.out.println(rowNum + " :  "+eachRow.getText());
            rowNum++;
        }
        System.out.println("2ND ROW DATA : "+allRows.get(allRows.size()-1).getText());
        //    Task 3 : Print Last row data only
    }
    //    Task 4 : Print column 5 data in the table body

        @Test
    public void printColumns() throws IOException {
            driver.get("https://the-internet.herokuapp.com/tables");
            extentTest
                    .pass("Taking the screenshot of the home page")
                    .assignDevice("Windows","Chrome")
                    .assignCategory("Smoke","Regression","Integration")
                    .assignAuthor("Rufat","Necmettin","Neslihan")
                    .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
            List<WebElement> column5Data = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
            column5Data.forEach(eachData-> System.out.println(eachData.getText()));

        }
/*    Task 5 : Write a method that accepts 2 parameters
      Parameter 1 = row number
      Parameter 2 = column number
      printData(2,3);  => prints data in 2nd row 3rd
 */
    @Test
    public void Test(){
        driver.get("https://the-internet.herokuapp.com/tables");
        int rowNumber = 2;
        int columnNumber = 3;
        WebElement cellData = driver.findElement(By.xpath("//table[@id='table1']//tr["+rowNumber+"]//td["+columnNumber+"]"));
        System.out.println("cellData("+rowNumber+","+columnNumber+") = " + cellData.getText());
    }
}