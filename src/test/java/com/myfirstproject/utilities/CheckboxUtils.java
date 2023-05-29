package com.myfirstproject.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.myfirstproject.utilities.TestBase.driver;

public class CheckboxUtils  {
    //    CHECKBOX BUTTON
    public static void clickCheckboxByIndex(int index){
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        if (!checkboxes.get(index).isSelected()){
            checkboxes.get(index).click();
        }

    }
    public static void clickAllCheckboxes(){
       List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int numOfCheckboxes =checkboxes.size();
        try{
            for (int  i=0;i<numOfCheckboxes;i++){
                if (!checkboxes.get(i).isSelected()) {
                    checkboxes.get(i).click();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
