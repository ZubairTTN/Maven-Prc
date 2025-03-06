package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyClaimPage {
    WebDriver driver;

    // Locators
    By myClaimsMenu = By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab') and contains(text(), 'My Claims')]");
    By latestClaim = By.xpath("//table/tbody/tr[1]/td[contains(text(), 'Submitted')]"); // Verify claim status

    // Constructor
    public VerifyClaimPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify the claim submission
    public boolean isClaimSubmitted() {
        driver.findElement(myClaimsMenu).click();
        return driver.findElements(latestClaim).size() > 0;
    }
}