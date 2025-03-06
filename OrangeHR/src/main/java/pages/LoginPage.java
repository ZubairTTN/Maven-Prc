package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // XPath Locators
    By usernameField = By.xpath("//input[@name='username']");
    By passwordField = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[contains(@class, 'orangehrm-login-button')]");
    By dashboard = By.xpath("//h6[text()='Dashboard']"); // To verify login success

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Perform login
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Verify login success
    public boolean isLoginSuccessful() {
        return driver.findElements(dashboard).size() > 0;
    }
}