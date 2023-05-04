package homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

// Create A Class: AmazonDropdown
public class AmazonDropdown extends TestBase {

    // Create A Method dropdownTest
    @Test
    public void  dropdownTest(){
    // Go to https://www.amazon.com/
       driver.get("https://www.amazon.com/");

    // Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
       WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
    // Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code
    // out and continue rest of the test case.
       Select options =new Select(dropdownElement);
       String actualOption = options.getFirstSelectedOption().getText();
       System.out.println("actualOption = " + actualOption);
       String expectedOption01 ="All Departments";

       Assert.assertEquals("actual option is not 'All Departments' ",expectedOption01,actualOption);

    // Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you
    // select you need to use get first selected option method). If it fails, then comment that code out and
    // continue rest of the test case.
       options.selectByIndex(3);
       String fourthIndexOption = options.getFirstSelectedOption().getText();
       String expectedOption02 ="Amazon Devices";
       //Assert.assertEquals("actual option is not 'Amazon Devices' ",expectedOption02,fourthIndexOption);
       if (fourthIndexOption.equals(expectedOption02)){
           System.out.println("TEST PASSED");

       }else {
           System.out.println("TEST FAILED");
           System.out.println("actualOption02 = " + fourthIndexOption);
           System.out.println("expectedOption02 = " + expectedOption02);
       }

    // Print all of the dropdown options -getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> allOptions = options.getOptions();

        for (WebElement w:allOptions) {
            System.out.print(w.getText()+"; ");
        }
        System.out.println();
    // Print the total number of options in the dropdown
       int numOfOptions = allOptions.size();
       System.out.println("numOfOptions = " + numOfOptions);

    // Assert if ‘Appliances’ is a dropdown option. Print true if “Appliances” is an option. Print false otherwise.
        boolean existanceOfanElement = allOptions.stream().collect(Collectors.toList()).contains("Appliances");
        System.out.println("existanceOfanElement = " + existanceOfanElement);

    }

}

           // BONUS: Assert if the dropdown is in Alphabetical Order
