package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserFactory {

    static WebDriver driver;

    @BeforeTest
    public static WebDriver startBrowser(String browserChoice, String url) {
        if (browserChoice.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserChoice.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    @Test
    public void test(){

        startBrowser ("Chrome","https://www.saucedemo.com/");
    }
}
