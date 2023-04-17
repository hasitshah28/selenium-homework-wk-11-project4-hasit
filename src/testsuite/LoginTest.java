package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        //Verify the text “PRODUCTS”
        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[text()='Products']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        //Verify that six products are displayed on page
        List<WebElement> actualElementList =  driver.findElements(By.className("inventory_item"));
        System.out.println("Total products are: " + actualElementList.size());
    }
    public void closeBrowser(){
        driver.quit();
    }
}
