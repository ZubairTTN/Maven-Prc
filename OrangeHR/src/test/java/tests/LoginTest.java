package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        System.out.println("Starting Login Test...");
        BaseClass.startBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(BaseClass.driver);
    }

    @Test(priority = 1, description = "Verify login with valid credentials")
    public void testLogin() {
        loginPage.login("Admin", "admin123");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
        System.out.println("Login Test Passed!");
    }

    @AfterClass
    public void teardown() {
        System.out.println("Closing the browser");
        BaseClass.closeBrowser();


    }
}