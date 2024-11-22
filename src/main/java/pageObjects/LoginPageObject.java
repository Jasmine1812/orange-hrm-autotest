package pageObjects;

import commons.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BaseActions {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @Step("Enter to Username textbox with value {username}")
    public void enterToUserNameTextBox(String username) {
        waitForElementVisible(LoginPageUI.USER_NAME_TEXTBOX);
        sendKeyToElement(LoginPageUI.USER_NAME_TEXTBOX, username);
    }

    @Step("Enter to Password textbox with value {password}")
    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Login button")
    public DashboardPageObject clickToLoginButton() {
        waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
        clickToElement(LoginPageUI.LOGIN_BUTTON);
//        waitForSpinnerIconInvisible();
        return PageGenerator.getHomepage(driver);
    }

}
