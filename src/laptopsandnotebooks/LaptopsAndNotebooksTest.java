package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        clickOnElement(By.xpath("//span[normalize-space()='Currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        // .1 Mouse hover on Laptops & Notebooks Tab.and click
        WebElement tab = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tab).click().build().perform();

        // 1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        // 1.3 Select Sort By "Price (High > Low)"
        WebElement sortBy = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Price (High > Low)");//Select by visible text

        // 1.4 Verify the Product price will arrange in High to Low order.


    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {

        //   2.1 Mouse hover on Laptops & Notebooks Tab and click
        WebElement tab = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tab).click().build().perform();
        //   2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //   2.3 Select Sort By "Price (High > Low)"
        WebElement sortBy = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Price (High > Low)");//Select by visible text
        //   2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        //  2.5 Verify the text “MacBook”
        String expectedDisplay = "MacBook";
        String actualDisplay = driver.findElement(By.xpath("//h1[normalize-space()='MacBook']")).getText();
        Assert.assertEquals(expectedDisplay, actualDisplay);
        //   2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //  2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedMessage = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //    2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //   2.9 Verify the text "Shopping Cart  (0.00kg)"
        String expectedDisplay1 = "Shopping Cart  (0.00kg)";
        String actualDisplay1 = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).getText();
        Assert.assertEquals(expectedDisplay1, actualDisplay1);
        //   2.10 Verify the Product name "MacBook"
        String expectedDisplay2 = "MacBook";
        String actualDisplay2 = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).getText();
        Assert.assertEquals(expectedDisplay2, actualDisplay2);
        //  2.11 Change Quantity "2"
        clearTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        //   2.12 Click on “Update”Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //   2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedDisplay3 = "Success: You have modified your shopping cart!\n" +
                "×";
        String actualDisplay3 = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        Assert.assertEquals(expectedDisplay3, actualDisplay3);
        //  2.14 Verify the Total £737.45
        String expectedTotal = "£737.45";
        String actualTotal = driver.findElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
        Assert.assertEquals(expectedTotal, actualTotal);

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        // 2.16 Verify the text “Checkout”
        String expectedCheckout = "Checkout";
        String actualCheckout = driver.findElement(By.xpath("//h1[contains(text(),'Checkout')]")).getText();
        Assert.assertEquals(expectedCheckout, actualCheckout);
        //2.17 Verify the Text “New Customer”
        String expectedMessage1 = "New Customer";
        String actualMessage1 = driver.findElement(By.xpath("//h2[contains(text(),'New Customer')]")).getText();
        Assert.assertEquals(expectedMessage1, actualMessage1);
        // 2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        // 2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        // 2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Champa");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Chameli");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "monday@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "0123456789");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "15 Lindsay Avenue");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "Rugby");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "RG1 1AG");
        WebElement country = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
        Select select1 = new Select(country);
        select1.selectByVisibleText("United Kingdom");//Select by visible text
        WebElement state = driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
        Select select2 = new Select(state);
        select2.selectByVisibleText("Leicestershire");//Select by visible text
        // 2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        // 2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"Please don't leave at doorstep. Ring doorbell");
        // 2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        // 2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        // 2.25 Verify the message “Warning: Payment method required!”
        String expectedMessage3 = "Warning: Payment method required!\n"+ "×";
        String actualMessage3 = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        Assert.assertEquals(expectedMessage3, actualMessage3);
    }


    @After
    public void tearDown() {
        // closeBrowser();
    }


}
