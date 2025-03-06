package com.my.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Zubair");
        // Launch Browser
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the Website
        driver.get("https://www.marutisuzuki.com/");
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Title: " + driver.getTitle());

        // Click on the Facebook Link (Opens a New Tab)
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/MSArenaOfficial']")).click();

        // Get All Window Handles
        Set<String> allWindows = driver.getWindowHandles();

        // Switch to the Child Window
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Child Window Title: " + driver.getTitle());

                // Close the Child Window
//                driver.close();
                break;  // Exit loop after switching and closing
            }
        }

        // Switch Back to Parent Window
        driver.switchTo().window(parentWindow);

        // Find a Valid Text Element in the Parent Window
        try {
            WebElement parentTextElement = driver.findElement(By.xpath("//title"));
            System.out.println("Parent Window Text: " + parentTextElement.getText());
        } catch (Exception e) {
            System.out.println("Parent text element not found!");
        }

        // Close Browser
//        driver.quit();
    }
}
