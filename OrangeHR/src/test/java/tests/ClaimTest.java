package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SubmitClaimPage;
import pages.VerifyClaimPage;

public class ClaimTest {
    LoginPage loginPage;
    SubmitClaimPage submitClaimPage;
    VerifyClaimPage verifyClaimPage;

    @BeforeClass
    public void setup() {
        System.out.println("Starting Claim Test...");

        // Initialize Browser & Open URL
        BaseClass.startBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Initialize Page Objects
        loginPage = new LoginPage(BaseClass.driver);
        submitClaimPage = new SubmitClaimPage(BaseClass.driver);
        verifyClaimPage = new VerifyClaimPage(BaseClass.driver);

        // Perform Login
        loginPage.login("Admin", "admin123");

        // Assert login success
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed! Please check credentials.");
    }

    @Test(priority = 1, description = "Submit a claim")
    public void testSubmitClaim() throws InterruptedException {
        submitClaimPage.submitClaim();
        System.out.println("Claim Submitted Successfully!");
    }

    @Test(priority = 2, description = "Verify submitted claim")
    public void testVerifyClaim() {
        Assert.assertTrue(verifyClaimPage.isClaimSubmitted(), "Claim verification failed!");
        System.out.println("Claim Verified Successfully!");
    }

    @AfterClass
    public void teardown() {
        System.out.println("Closing the browser...");
        BaseClass.closeBrowser();  // ✅ Closing browser to free resources
    }
}
