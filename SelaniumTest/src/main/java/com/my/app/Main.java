package com.my.app;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

public class Main{
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Wait for 10 seconds

        WebElement forgotPassText= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p"));
        System.out.println(forgotPassText.getText());


        WebElement userField = driver.findElement(By.name("username"));
        WebElement passField =driver.findElement(By.name("password"));

        userField.sendKeys("Admin");
        passField.sendKeys("admin123");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
        System.out.println(element.getText());

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println(driver.getTitle());


        WebElement dashboardText= driver.findElement(By.tagName("h6"));
        System.out.println(dashboardText.getText());

        // Take a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshot.png"));
            System.out.println("Screenshot saved as screenshot.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
