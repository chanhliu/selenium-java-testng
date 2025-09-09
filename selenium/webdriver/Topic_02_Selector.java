package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Topic_02_Selector {
    WebDriver driver;

    @BeforeClass
    public void init() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8008/#/public/login");
    }

    @Test
    public void TC_01_Register() {





    }

    @AfterClass
    public void tearDown() {
        try {
            Thread.sleep(10_000);
            ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}