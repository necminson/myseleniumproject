package com.myfirstproject.practises.practise01.practise02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q05_DragAndDropCapitals extends TestBase {
    @Test
    public void Test(){

        // Go to URL :
            driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        // Match capitals with countries
        // Locate Capitals
        WebElement capital1 = driver.findElement(By.id("box1"));
        WebElement capital2 = driver.findElement(By.id("box2"));
        WebElement capital3 = driver.findElement(By.id("box3"));
        WebElement capital4 = driver.findElement(By.id("box4"));
        WebElement capital5 = driver.findElement(By.id("box5"));
        WebElement capital6 = driver.findElement(By.id("box6"));
        WebElement capital7 = driver.findElement(By.id("box7"));

        // Locate Counties
        WebElement country1 = driver.findElement(By.id("box101"));
        WebElement country2 = driver.findElement(By.id("box102"));
        WebElement country3 = driver.findElement(By.id("box103"));
        WebElement country4 = driver.findElement(By.id("box104"));
        WebElement country5 = driver.findElement(By.id("box105"));
        WebElement country6 = driver.findElement(By.id("box106"));
        WebElement country7 = driver.findElement(By.id("box107"));

        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(capital1,country1)
                .dragAndDrop(capital2,country2)
                .dragAndDrop(capital3,country3)
                .dragAndDrop(capital4,country4)
                .dragAndDrop(capital5,country5)
                .dragAndDrop(capital6,country6)
                .dragAndDrop(capital7,country7)
                .build()
                .perform();


    }

}
