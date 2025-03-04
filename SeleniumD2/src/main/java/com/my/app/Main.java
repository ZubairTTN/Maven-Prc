package com.my.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
//        selecting INDIA from dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select drop = new Select(dropDown);
        drop.selectByValue("INDIA");

//        Login
        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName= driver.findElement(By.name("lastName"));
        firstName.sendKeys("Zubair");
        lastName.sendKeys("Ahmed");
        WebElement sub = driver.findElement(By.name("submit"));
        sub.click();

//        Assertion
        WebElement txt = driver.findElement(By.xpath("//font[contains(text(), 'Thank you for')]"));
        String fullText = txt.getText();
        System.out.println(fullText);
    String expected = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
        Assert.assertEquals(fullText, expected, "Test case failed" );



        Thread.sleep(10000);
        driver.close();
        driver.quit();
    }
}