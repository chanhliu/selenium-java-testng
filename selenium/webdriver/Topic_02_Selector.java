package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_02_Selector {
    WebDriver driver;

    @BeforeClass
    public void init()
    {
        driver = new FirefoxDriver();
        driver.get("https://www.nopcommerce.com/en/register");
    }



    @Test
    public void TC_01_Register() {
//        driver.findElement(By.linkText("Shopping cart")).click();
        driver.findElement(By.id("FirstName")).sendKeys("John");

        String test = driver.findElement(By.className("navigation-shopping-cart")).getAttribute("href");

        System.out.println("Testtt" + test);
//        List<WebElement> els = driver.findElements(By.xpath("//*[@href=\"/en/cart\"]"));
//         els.iterator().next().click();

        driver.findElements(By.tagName("a")).get(0).click();
    }

    @AfterClass
    public void tearDown(){
        try {
            Thread.sleep(10_000);;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}