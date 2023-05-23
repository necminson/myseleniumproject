package com.myfirstproject.day15;

import com.sun.activation.registries.MailcapParseException;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.myfirstproject.utilities.ReusableMethodsUtils.waitFor;
import static org.junit.Assert.assertEquals;

public class Day15_ReadExcel {
    //Import the apache poi dependency in your pom file
    //Create resources directory under java folder(right click on java and create the folder)
    //Add the excel file on the resources folder
    //Create a new package: excelautomation
    //Create a new class : ReadExcel
    //Create a new test method : readExcel()
    @Test
    public void readExcelTest() throws Exception {
    //Store the path of the  file in a string
        String path = "resources/Capitals.xlsx";
    //Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
    //Open the workbook using fileInputStream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
    //Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1"); // Getting Sheet1 by name
        // workbook.getSheetAt(0);// ALTERNATIVELY Getting Sheet1 by index
    //Go to first row
        Row row1 = sheet1.getRow(0); // index starts at 0
    //Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);
        System.out.println("cell1 = " + cell1);
    //Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println("cell2 = " + cell2);
    //Go to 2nd row first cell  and assert if the data equal to USA
        Row row2 = sheet1.getRow(1);
        Cell row2cell3 = row2.getCell(0);
        System.out.println("row2cell3 = " + row2cell3);
        assertEquals("USA",row2cell3.toString());
    //Go to 3rd row 2nd cell-chain the row and cell
        Cell row2Cell1 = sheet1.getRow(2).getCell(1);
        System.out.println("row2Cell1 = " + row2Cell1.toString().toUpperCase());
    //Find the number of row
        int totalRowCount = sheet1.getLastRowNum()+1;// index starts at 0
        System.out.println("totalRowCount = " + totalRowCount);
    //Find the number of used row
        int usedRowCount = sheet1.getPhysicalNumberOfRows();
        System.out.println("usedRowCount = " + usedRowCount);// index starts at 1
    //Print country, capitol key value pairs as map object
        Map<String,String> capitalOfCountry = new HashMap<>();
        for (int i = 1; i < usedRowCount; i++) {
                String country = sheet1.getRow(i).getCell(0).toString().toUpperCase();
                String capital= sheet1.getRow(i).getCell(1).toString();
                capitalOfCountry.put(country,capital);
        }
        System.out.println("capitalOfCountry = " + capitalOfCountry);

    }
}
