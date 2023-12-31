package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String menu;
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {
        this.menu = menu;
        driver.findElement(By.xpath(menu)).click();

    }

    @Test
    public void check() {
        menu = "//a[normalize-space()='Desktops']";
        selectMenu(menu);
    }


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        // 1.1 Mouse hover on “Desktops” Tab and click
        WebElement desktops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(desktops).click().build().perform();
        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        menu = "//a[normalize-space()='Show AllDesktops']";
        selectMenu(menu);
        // 1.3 Verify the text ‘Desktops’
        String expectedDesktops = "Desktops";
        String actualDesktops = getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']"));
        Assert.assertEquals(expectedDesktops, actualDesktops);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        WebElement Laptops = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Laptops).click().build().perform();

        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        menu = "//a[normalize-space()='Show AllLaptops & Notebooks']";
        selectMenu(menu);

        // 2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = driver.findElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        // 3.1 Mouse hover on “Components” Tab and click
        WebElement components = driver.findElement(By.xpath("//a[normalize-space()='Components']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(components).click().build().perform();
        // 3.2 call selectMenu method and pass the menu = “Show All Components”
        menu = "//a[normalize-space()='Show AllComponents']";
        selectMenu(menu);
        //  3.3 Verify the text ‘Components
        String expectedText = "Components";
        String actualText = driver.findElement(By.xpath("//h2[normalize-space()='Components']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }


    @After
    public void tearDown() {
        // closeBrowser();
    }


}





















