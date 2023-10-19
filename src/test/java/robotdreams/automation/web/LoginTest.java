package robotdreams.automation.web;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import robotdreams.automation.app.web.DashboardPage;
import robotdreams.automation.app.web.LoginPage;
import robotdreams.automation.base.BaseGUITest;
public class LoginTest extends BaseGUITest {

    @DataProvider(name = "loginData")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                {"user1", "admin"},
                {"admin", "1234"}
        };
    }
    @Test(dataProvider = "loginData", testName = "Negative cases using wrong user credentials")
    public void negativeLoginTest(String username, String password) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(loginPage.isAlertExists(), "Alert message should be displayed");
        soft.assertFalse(dashboardPage.isPageLoaded(), "User should not be able to login");
        soft.assertAll();
    }

    @Test(testName = "Login user with correct credentials")
    public void SuccessLoginTest() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.login("admin", "admin");
        dashboardPage.confirm();
        System.out.println("User is logged");
    }
}
