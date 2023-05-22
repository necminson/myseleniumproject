package com.myfirstproject.practises.Practise03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class Q03_AddDeleteElements extends TestBase {
    @Test
    public void addDeleteElementsTest(){

    // Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    // Click on the "Add Element" button 100 times
       WebElement addElement =  driver.findElement(By.xpath("//button[.='Add Element']"));
       int numOfAddedElement = 100;
       int numOfDeletedElement = 20;
        for (int i = 0; i < numOfAddedElement; i++) {
            addElement.click();
        }
    // Click on the "Delete" button 20 times

          List<WebElement> deleteButtons =driver.findElements(By.xpath("//button[.='Delete']"));
        for (int i = 0; i < numOfDeletedElement; i++) {
            deleteButtons.get(i).click();
        }

    // Assert that 20 buttons were deleted.

        int sizeAfterDelete = driver.findElements(By.xpath("//button[.='Delete']")).size();
        int sizeBeforeDelete = deleteButtons.size();
        assertEquals(sizeBeforeDelete-numOfDeletedElement,sizeAfterDelete);

    }
}
