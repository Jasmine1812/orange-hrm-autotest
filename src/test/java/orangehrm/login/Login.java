package orangehrm.login;

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
    //log
    @Test
    public void TC_01_Login_Success() {
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUserNameTextBox("Admin");
        loginPage.enterToPasswordTextBox("Admin@admin123");
        homepage = loginPage.clickToLoginButton();
        verifyFalse(homepage.isTimeAtWorkTextboxDisplayed());
    }
    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }




}
