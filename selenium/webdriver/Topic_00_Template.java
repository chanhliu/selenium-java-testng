package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void init()
    {
        driver = new FirefoxDriver();
        driver.get("hhttps://www.nopcommerce.com/en");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.id(""));
    }


}