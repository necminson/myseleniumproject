package com.myfirstproject.practises.Practise03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.myfirstproject.utilities.ReusableMethodsUtils.waitFor;

public class Q05_ToDoList extends TestBase {
            /*
        Given
            Go to http://webdriveruniversity.com/To-Do-List/index.html
        When
            Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        And
            Strikethrough all todos.
        And
            Delete all todos.
        Then
            Assert that all todos deleted.
         */
     @Test
    public void toDoListTest(){

         //Go to http://webdriveruniversity.com/To-Do-List/index.html
      driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
         //Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
      List<String> toDoList= new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));
       WebElement toDoInput = driver.findElement(By.xpath("//input[@type='text']"));
         for (String w:  toDoList ) {
            waitFor(3000);
            toDoInput.sendKeys(w+ Keys.ENTER);
         }
         //Strikethrough all todos.

         //Delete all todos.

        // Assert that all todos deleted.
     }
}
