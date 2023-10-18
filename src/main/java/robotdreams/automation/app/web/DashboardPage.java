package robotdreams.automation.app.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import robotdreams.automation.base.BaseSelenidePage;

public class DashboardPage extends BaseSelenidePage {

    @Override
    protected SelenideElement readyElement() {
        return this.avatarDropdown;
    }
    final public SelenideElement kanboardLogo = Selenide.$x("//a[@href='/dashboard']");
    final public SelenideElement myNotificationsIcon = Selenide.$x("//a[@href='/user/1/notifications/web']");
    final public SelenideElement headerDropdown = Selenide.$x("//a[@class='dropdown-menu dropdown-menu-link-icon']");
    final public SelenideElement avatarDropdown = Selenide.$x("//div[@class='avatar-letter']");
    final public SelenideElement newProjectLink = Selenide.$x("//*[@id='main']/div/ul/li[1]/a");
    final public SelenideElement newPersonalProjectLink = Selenide.$x("//a[@href='/project/create/personal']");
    final public SelenideElement projectManagementLink = Selenide.$x("//a[@href='/projects']");
    final public SelenideElement myActivityStreamLink = Selenide.$x("//a[@href='/my-activity']");
    final public SelenideElement overviewSection = Selenide.$x("//a[@href='/dashboard/1']");
    final public SelenideElement myProjectsSection = Selenide.$x("//a[@href='/dashboard/1/projects']");
    final public SelenideElement myTasksSection = Selenide.$x("//a[@href='/dashboard/1/tasks']");
    final public SelenideElement mySubtasksSection = Selenide.$x("//a[@href='/dashboard/1/subtasks']");
    final public SelenideElement searchField = Selenide.$x("//input[@name='search']");
    final public SelenideElement filterDropdown = Selenide.$x("//div[@class='input-addon-item']");

    public NewProjectBox openProjectBox() {
        this.newProjectLink.click();
        return new NewProjectBox();
    }
}
