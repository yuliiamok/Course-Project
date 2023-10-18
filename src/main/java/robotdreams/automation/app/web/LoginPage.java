package robotdreams.automation.app.web;

import com.codeborne.selenide.*;
import robotdreams.automation.base.BaseSelenidePage;

public class LoginPage extends BaseSelenidePage {
    final public ElementsCollection menusContainer = Selenide.$$x("//div[@class='menus-container']");
    final public ElementsCollection pageHeader = Selenide.$$x("//div[@class='page-header']']");
    final public SelenideElement username = Selenide.$x("//input[@id='form-username']");
    final public SelenideElement password = Selenide.$x("//input[@id='form-password']");
    final public SelenideElement submitBtn = Selenide.$x("//button[@type='submit']");
    final public SelenideElement alertMessage = Selenide.$x("//p[@class='alert alert-error']");
    final public SelenideElement rememberMeCheckbox = Selenide.$x("//input[@type='checkbox']");
    final public SelenideElement forgotPasswordLink = Selenide.$x("//a[@href='/forgot-password']");

    @Override
    protected SelenideElement readyElement() {
        return Selenide.$x("//div[@class='form-login']");
    }
//    public boolean isErrorMessagePresent() {
//        Wait.waitWhilePageIsLoading();
//        try {
//            alertMessage.shouldBe(
//                    CollectionCondition.allMatch("exist", WebElement::isDisplayed),
//                    Duration.ofSeconds(5));
//        } catch (Throwable e) { /* Ignore */}
//
//        return !alertMessage.isEmpty();
//    }
    public boolean isAlertExists() {
        try {
            Selenide.$x("//p[@class='alert alert-error']").should(Condition.exist);
            return true;
        } catch (Throwable e) {}
        return false;
    }

    public DashboardPage login(String username, String password) {
        this.username.val(username);
        this.password.val(password);
        this.submitBtn.click();

        return new DashboardPage();
    }
}
