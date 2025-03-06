package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubmitClaimPage {
    WebDriver driver;
    // Locators
    By claimsMenu = By.xpath("//span[text()='Claim']");
    By submitClaimButton = By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab') and contains(text(), 'Submit Claim')]");
    By eventDropdown = By.xpath("//div[@class='oxd-select-text-input' and contains(text(),'Select')]");
    By eventOption = By.xpath("//div[contains(@class, 'oxd-select-dropdown') and contains(., 'Accommodation')]");
    By currencyDropdown = By.xpath("//div[@class='oxd-select-text-input' and contains(text(),'Select')]");
    By currencyOption = By.xpath("//div[@class='oxd-select-option']//span[contains(text(),'Indian')]");
    By remark = By.xpath("//textarea");
    By submitButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

    // Constructor
    public SubmitClaimPage(WebDriver driver) {
        this.driver = driver;
    }

    // Submit a new claim
    public void submitClaim() throws InterruptedException{
        // Click on Claims menu
        driver.findElement(claimsMenu).click();

        // Click on Submit Claim Button
        driver.findElement(submitClaimButton).click();

        // Select Event
        driver.findElement(eventDropdown).click();
        driver.findElement(eventOption).click();
        Thread.sleep(2000);

        // Select Currency
        driver.findElement(currencyDropdown).click();
        driver.findElement(currencyOption).click();
        Thread.sleep(2000);

        // Enter Remarks
        driver.findElement(remark).sendKeys("Zubair");

        // Click Create
        driver.findElement(submitButton).click();
    }
}
