package orangehrm.login;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DashboardPageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGenerator;
import utilities.reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
@Feature("Login")
public class Login_Allure extends BaseTest {
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
    @Description("TC01 - Login to system")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_01_Login_Success() {
//        log.info("Login - Step 01: Open Login page");
        loginPage = PageGenerator.getLoginPage(driver);

//        log.info("Login - Step 02: Input to Username textbox");
        loginPage.enterToUserNameTextBox("Admin");

//        log.info("Login - Step 03: Input to Password textbox");
        loginPage.enterToPasswordTextBox("Admin@admin123");

//        log.info("Login - Step 04: Click to Login button");
        homepage = loginPage.clickToLoginButton();

//        log.info("Login - Step 05: Verify Welcome message displayed");
        verifyTrue(homepage.isTimeAtWorkTextboxDisplayed());
//        Assert.assertFalse(homepage.isTimeAtWorkTextboxDisplayed());
    }
    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }




}
