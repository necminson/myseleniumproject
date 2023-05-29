package com.myfirstproject.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.myfirstproject.utilities.TestBase.driver;

public class RadioButtonUtils {
    //    RADIO BUTTON
    public static void clickRadioByIndex(int index){
       List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
       if (!radios.get(index).isSelected()){
           radios.get(index).click();
       }

    }
}
