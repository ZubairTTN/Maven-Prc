package com.my.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
//        Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Wait for 10 Seconds, this is implicit wait and it is global

        //        Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //this is explicit wait and ir contains some conditions

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

//        Fluent wait
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement fluentElement = fluentWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("user-name")));


        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String title = driver.getTitle();
        System.out.println(title);
       // driver.navigate().back();
        //1000Thread.sleep(1000);

//        //1000Thread.sleep(1000);
      //  driver.navigate().forward();
        //1000Thread.sleep(1000);

      //  driver.navigate().refresh();
        //1000Thread.sleep(1000);

        WebElement idElement = driver.findElement(By.id("user-name"));
        System.out.println(idElement);

        WebElement pathElement = driver.findElement(By.xpath("//*[@id='user-name']"));
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);


        WebElement elementById = driver.findElement(By.id("user-name"));
        elementById.click();
        //1000Thread.sleep(1000);
        elementById.sendKeys("standard_user");
        //1000Thread.sleep(1000);
        elementById.clear();
        //1000Thread.sleep(1000);
        elementById.click();
        elementById.sendKeys("problem_user");
        //1000Thread.sleep(1000);
        WebElement elementPass = driver.findElement(By.id("password"));
        //1000Thread.sleep(1000);
        elementPass.click();
        elementPass.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        //1000Thread.sleep(1000);
        login.click();
       // WebElement SwagL = driver.findElement(By.className("login_logo"));
       // System.out.println(SwagL.getText());

        String attribute = driver.findElement(By.xpath("//*[text()='Products']")).getDomAttribute("data-test");
        System.out.println(attribute);
//        System.out.println("test1");

        boolean dis = driver.findElement(By.xpath("//*[text()='Products']")).isDisplayed();
        System.out.println(dis);
//        System.out.println("test2");
//        System.out.println(driver.findElement(By.xpath("//select[@class='product_sort_container']/option")));
        List<WebElement> ls = driver.findElements(By.xpath("//select[@class='product_sort_container']/option"));
        for(WebElement l : ls )
        {
            System.out.println(l.getText());
        }
        System.out.println(ls.contains("Name (A to Z)"));

        String value = driver.findElement(By.id("user-name")).getAttribute("value");
        System.out.println("Entered value: " + value);


//        WebElement element = driver.findElement(By.id(id="user-name"));
        driver.close();
        driver.quit();
    }
}