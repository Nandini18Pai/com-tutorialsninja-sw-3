package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
        clickOnElement(By.xpath("//span[normalize-space()='Currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){

     //    1.1 Mouse hover on Desktops Tab.and click
        WebElement desktopsTab = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(desktopsTab).click().build().perform();
      //  1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
      //  1.3 Select Sort By position "Name: Z to A"

        WebElement sortBy = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/select[1]"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Name (Z - A)");//Select by visible text


      //  1.4 Verify the Product will arrange in Descending order.
        String expectedDisplay = "Name (Z - A)";
        String actualDisplay = driver.findElement(By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']")).getText();
        Assert.assertEquals(expectedDisplay, actualDisplay);


        }

        @Test
        public void verifyProductAddedToShoppingCartSuccessFully() {

            // 1.1 Mouse hover on Desktops Tab.and click
            WebElement desktopsTab = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(desktopsTab).click().build().perform();
            // 2.2 Click on “Show All Desktops”
            clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

            //  2.3 Select Sort By position "Name: A to Z"
            WebElement sortBy = driver.findElement(By.xpath("//select[@id='input-sort']"));
            Select select = new Select(sortBy);
            select.selectByVisibleText("Name (A - Z)");//Select by visible text

            // 2.4 Select product “HP LP3065”
            clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

            //  2.5 Verify the Text "HP LP3065"
            String expectedDisplay = "HP LP3065";
            String actualDisplay = driver.findElement(By.xpath("//h1[contains(text(),'HP LP3065')]")).getText();
            Assert.assertEquals(expectedDisplay, actualDisplay);

            // 2.6 Select Delivery Date "2022-11-30
            clearTextToElement(By.xpath("//input[@id='input-option225']"));
            sendTextToElement(By.xpath("//input[@id='input-option225']"), "2022-11-30");

            // 2.7.Enter Qty "1” using Select class.
            clearTextToElement(By.xpath("//input[@id='input-quantity']"));
            sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");

            // 2.8 Click on “Add to Cart” button
            clickOnElement(By.xpath("//button[@id='button-cart']"));

            // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
            String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n" +
                    "×";
            String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
            Assert.assertEquals(expectedMessage, actualMessage);
            // 2.10 Click on link “shopping cart” display into success message
            clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

            // 2.11 Verify the text "Shopping Cart"
            String expectedCart = "Shopping Cart  (1.00kg)";
            String actualCart = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).getText();
            Assert.assertEquals(expectedCart, actualCart);

            //  2.12 Verify the Product name "HP LP3065"
            String expectedName = "HP LP3065";
            String actualName = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).getText();
            Assert.assertEquals(expectedName, actualName);

            //  2.13 Verify the Delivery Date "2022-11-30"
            String expectedDate = "Delivery Date:2022-11-30";
            String actualDate = driver.findElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]")).getText();
            Assert.assertEquals(expectedDate, actualDate);

            //  2.14 Verify the Model "Product 21"
            String expectedModel = "Product 21";
            String actualModel = driver.findElement(By.xpath("//td[normalize-space()='Product 21']")).getText();
            Assert.assertEquals(expectedModel, actualModel);

            //  2.15 Verify the Today  "£74.73
            String expectedTotal = "£74.73";
            String actualTotal = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
            Assert.assertEquals(expectedTotal, actualTotal);

        }

    @After
    public void tearDown() {
        // closeBrowser();
    }




}
