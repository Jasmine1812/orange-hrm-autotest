package pageObjects;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;
import pageUIs.DashboardPageUI;


public class DashboardPageObject extends BaseActions {
    private WebDriver driver;
    public DashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToPIMLink() {
        waitForElementClickable(DashboardPageUI.PIM_LINK);
        clickToElement(DashboardPageUI.PIM_LINK);
    }

//    public EmployeeListPageObject openEmployeeListPage() {
//        clickToPIMLink();
//        waitForSpinnerIconInvisible();
//        return PageGenerator.getEmployeeListPage(driver);
//    }
}
