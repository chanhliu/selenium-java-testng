package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selector {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void init() {
        driver.get("http://localhost:8008/#/public/login");
    }

    @Test
    public void TC_01_Register() {
        sleep(3000);
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        sleep(3000);
        driver.findElement(By.id("submenu_user-management")).click();

        sleep(3000);
        driver.findElement(By.id("user-and-group-add-button")).click();

        sleep(3000);
        driver.findElement(By.id("user-description")).sendKeys("123\n456");

    }

    @AfterClass
    public void tearDown() {
        sleep(5_000);
        driver.close();
    }

    public void sleep(long second) {
        try {
            Thread.sleep(second);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}