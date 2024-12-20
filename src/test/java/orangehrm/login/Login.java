package orangehrm.login;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DashboardPageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGenerator;
import utilities.reportConfig.ExtentManager;
import utilities.reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Login extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject homepage;
    private String browserName;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;

    }

    //Data
    //Connect to DB
    //Report
    //Assert and verify --> Done
    //log --> Done
    @Test
    public void TC_01_Login_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_01_Login_Success " + browserName);

//        log.info("Login - Step 01: Open Login page");
        ExtentTestManager.getTest().log(Status.INFO,"Login - Step 01: Open Login page");
        loginPage = PageGenerator.getLoginPage(driver);

//        log.info("Login - Step 02: Enter to Username textbox" + "Admin");
        ExtentTestManager.getTest().log(Status.INFO,"Login - Step 02: Enter to Username textbox" + "Admin");
        loginPage.enterToUserNameTextBox("Admin");

//        log.info("Login - Step 03: Enter to Password textbox" + "Admin@admin123");
        ExtentTestManager.getTest().log(Status.INFO,"Login - Step 03: Enter to Password textbox" + "Admin@admin123");
        loginPage.enterToPasswordTextBox("Admin@admin123");

        ExtentTestManager.getTest().log(Status.INFO,"Login - Step 04: Click to Login button");
        log.info("Login - Step 04: Click to Login button");

        ExtentTestManager.getTest().log(Status.INFO,"Login - Step 05: Verify Homepage is displayed");
        homepage = loginPage.clickToLoginButton();
        verifyTrue(homepage.isTimeAtWorkTextboxDisplayed());
//        Assert.assertFalse(homepage.isTimeAtWorkTextboxDisplayed());
    }
    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }




}
