package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;


    public static void startBrowser(String url) {
        //System.setProperty("webdriver.chrome.driver", "C:\Program Files\Google\Chrome\Application"); // Update path
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}