package homeworks;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import com.myfirstproject.utilities.instructorAhmetsUtilities.AllCreatedMethodUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import static com.myfirstproject.utilities.CheckboxUtils.clickAllCheckboxes;
import static com.myfirstproject.utilities.CheckboxUtils.clickCheckboxByIndex;
import static com.myfirstproject.utilities.JSUtils.scrollAllTheWayDownJS;
import static com.myfirstproject.utilities.RadioButtonUtils.clickRadioByIndex;
import static com.myfirstproject.utilities.ScreenShotUtils.takeScreenshotOfTheEntirePage;
import static com.myfirstproject.utilities.WaitForUtils.explicitlyWaitForVisibility;
import static org.junit.Assert.assertEquals;

public class Homework03 extends TestBase {

    @Test
    public void task07(){
  /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below them
    Then
        Verify they are dropped.
  */

        //        Go to https://demo.guru99.com/test/drag_drop.html
            driver.get("https://demo.guru99.com/test/drag_drop.html");
            scrollAllTheWayDownJS();
        //        Drag orange elements on proper boxes below them
            Actions actions = new Actions(driver);
            actions
                    .dragAndDrop(explicitlyWaitForVisibility(By.id("credit2"),2),explicitlyWaitForVisibility(By.id("bank"),2)).release()
                    .dragAndDrop(explicitlyWaitForVisibility(By.id("fourth"),2),explicitlyWaitForVisibility(By.id("amt7"),2)).release()
                    .dragAndDrop(explicitlyWaitForVisibility(By.id("credit1"),2),explicitlyWaitForVisibility(By.id("loan"),2)).release()
                    .dragAndDrop(explicitlyWaitForVisibility(By.id("fourth"),2),explicitlyWaitForVisibility(By.id("amt8"),2)).release()
                    .perform();
        //        Verify they are dropped.
                    assertEquals("Perfect!",explicitlyWaitForVisibility(By.xpath("//a[.='Perfect!']"),2).getText());
    }
    @Test
    public void task08()  {

       /*
    Given
        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    When
        Fill the username, password and textArea comment:
    And
        Choose a file and upload it
    And
        Select all checkboxes, radio item 1 and dropdown 1
    And
        Click on submit
   Then
        Verify that uploaded file name is on the Form Details
        */
        //        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
                    driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        //        Fill the username, password and textArea comment:
                    explicitlyWaitForVisibility(By.name("username"),2).sendKeys(Faker.instance().name().username());
                    explicitlyWaitForVisibility(By.name("password"),2).sendKeys(Faker.instance().internet().password());
                    explicitlyWaitForVisibility(By.name("comments"),2).sendKeys(Faker.instance().lorem().characters());
        //        Choose a file and upload it
                    explicitlyWaitForVisibility(By.name("filename"),2).sendKeys("C:\\Users\\necme\\OneDrive\\Desktop\\TEAM-108.xlsx");
        //        Select all checkboxes, radio item 1 and dropdown 1
                    // All checkboxes
                    clickAllCheckboxes();
                    // radio 1
                    clickRadioByIndex(0);
                    // Selection item 1
                    Select items =new Select(explicitlyWaitForVisibility(By.name("multipleselect[]"),2));
                            items.deselectAll();
                            items.selectByValue("ms1");
                    // Dropdown 1
                     new Select(explicitlyWaitForVisibility(By.name("dropdown"),2)).selectByValue("dd1");
        //        Click on submit
                    explicitlyWaitForVisibility(By.xpath("//*[@name=\"submitbutton\"][2]"),2).click();
        //        Verify that uploaded file name is on the Form Details
                    assertEquals("TEAM-108.xlsx",explicitlyWaitForVisibility(By.id("_valuefilename"),2).getText());

    }
    @Test
    public void task09(){
       /*
Given
 Go to  https://www.saucedemo.com/
When
 Enter the username  as "standard_user"
And
 Enter the password as "secret_sauce"
And
 Click on login button
And
 Add all products to cart
And
 Go to cart
And
 Click on checkout
And
 Fill your information
And
 Click on continue
Then
 Assert that total price is $140.34
When
 Click on finish
Then
 Assert that CHECKOUT: COMPLETE!
*/
    }
    @Test
    public void task10(){
    /*
  Given
      Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
  When
      Click on "click me" button
  Then
      Verify that "Event Triggered"
   */
    }
    @Test
    public void task11(){
    /*
Given
   Go to https://testpages.herokuapp.com/
When
   Click on File Downloads
And
   Click on Server Download
Then
   Verify that file is downloaded
*/
    }
    @Test
    public void task12(){
        //We will make a roof of 5% of the height of the earliest built tower.
        //Find how many meters we will build.
     /*
    Given
        Go to https://www.techlistic.com/p/demo-selenium-practice.html
    When
        Put all built years into a list
    And
        Calculate min year
    And
        Put all heights into a list
    And
        Calculate the height to build
    Then
        Assert that build height is 25.45 meters
     */
    }
    @Test
    public void task13(){
     /*
    Given
        Save EarningList.xlsx file into your project
    When
        In the row column, write the row numbers according to the earnings amount(Natural Order).
    Then
        Assert that row number of Wednesday is 1
     */
/*
//EarningList.xlsx file:
Days	   Earnings   Row
Monday	    $512
Tuesday	    $205
Wednesday	         $632
Thursday	         $344
Friday	    $480
Saturday	         $0
Sunday	    $0

--------------------------
 */

    }
}
