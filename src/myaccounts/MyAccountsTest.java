package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";
    String option;

    public void selectMyAccountOptions(String option) {

        if (option == "Register") {
            WebElement select = driver.findElement(By.xpath("//a[@title='My Account']"));
            List<WebElement> options = select.findElements(By.xpath("//a[normalize-space()='Register']"));

            for (WebElement option1 : options) {

                if (option.equals(option1.getText())) {
                    option1.click();
                }

            }

        }
        if (option == "Login") {
            WebElement select1 = driver.findElement(By.xpath("//a[@title='My Account']"));
            List<WebElement> options1 = select1.findElements(By.xpath("//a[normalize-space()='Login']"));

            for (WebElement option2 : options1) {

                if (option.equals(option2.getText())) {
                    option2.click();

                }

            }

        }
        if (option == "Logout") {
            WebElement select2 = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
            List<WebElement> option2 = select2.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
            for (WebElement option3 : option2) {
                if (option.equals(option3.getText())) {
                    option3.click();

                }
            }
        }
    }

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        clickOnElement(By.xpath("//span[normalize-space()='Currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // 1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        option = "Register";
        selectMyAccountOptions(option);

        //1.3 Verify the text “Register Account”
        String expectedText = "Register Account";
        String actualText = driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        option = "Login";
        selectMyAccountOptions(option);

        //  2.3 Verify the text “Returning Customer”
        String expectedText = "Returning Customer";
        String actualText = driver.findElement(By.xpath("//h2[normalize-space()='Returning Customer']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {

        //  3.1 Click  on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //  3.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        option = "Register";
        selectMyAccountOptions(option);
        //  3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Champa");
        //  3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Chameli");
        //  3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "monday5@gmail.com");
        //  3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "01234564685");
        //  3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "monday@1");
        //  3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "monday@1");
        // 3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        //  3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //  3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //  3.12 Verify the message “Your Account Has Been Created!”
        String expectedText = "Your Account Has Been Created!";
        String actualText = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
        Assert.assertEquals(expectedText, actualText);
        // 3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // 3.14 Click  on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        option = "Logout";
        selectMyAccountOptions(option);
        // 3.16 Verify the text “Account Logout”
        String expectedResult1 = "Account Logout";
        String actualResult1 = driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]")).getText();
        Assert.assertEquals(expectedResult1, actualResult1);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //   4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //   4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        option = "Login";
        selectMyAccountOptions(option);
        //  4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "monday@gmail.com");
        //   4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "monday@1");
        //  4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //   4.7 Verify text “My Account”
        String expectedText = "My Account";
        String actualText = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).getText();
        Assert.assertEquals(expectedText, actualText);
        //  4.8 Click  on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //   4.9 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        option = "Logout";
        selectMyAccountOptions(option);
            //4.10 Verify the text “Account Logout”
        String expectedResult1 = "Account Logout";
        String actualResult1 = driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]")).getText();
        Assert.assertEquals(expectedResult1, actualResult1);
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }


    @After
    public void tearDown() {
        // closeBrowser();
    }


}
