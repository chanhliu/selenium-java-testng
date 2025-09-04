package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_01_Check_Environment {
    WebDriver driver;

    @Test
    public void TC_01_Run_On_Firefox() {
        driver = getDriver("firefox");
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC_02_Run_On_Chrome() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC_03_Run_On_Edge() {
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    public WebDriver getDriver(String driver ) {
        WebDriver webDriver;
        switch (driver) {
            case "chrome": webDriver = new ChromeDriver(); break;
            case "firefox": webDriver = new FirefoxDriver(); break;
            case "edge": webDriver = new EdgeDriver(); break;
            default: webDriver = new ChromeDriver(); break;
        }
        return webDriver;
    }
}