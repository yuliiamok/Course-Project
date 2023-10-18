package robotdreams.automation.app.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import robotdreams.automation.base.BaseSelenidePage;

public class SubmenuDropdown extends BaseSelenidePage {
    @Override
    protected SelenideElement readyElement() {
        return Selenide.$x("//ul[@class='dropdown-submenu-open']");
    }

    final public SelenideElement addNewTask = Selenide.$x("//*[@id='dropdown']/ul/li[1]/a");
    final public SelenideElement activity = Selenide.$x("//div[@id='dropdown']//li//a[@href='/project/1/activity']");
    final public SelenideElement addCustomFilter = Selenide.$x("//div[@id='dropdown']//li//a[@href='/project/1/customer-filters/create']");
    final public SelenideElement analytics = Selenide.$x("//div[@id='dropdown']//li//a[@href='/analytics/tasks/1']");
    final public SelenideElement exports = Selenide.$x("//div[@id='dropdown']//li//a[@href='/export/tasks/1']");
    final public SelenideElement importTasks = Selenide.$x("//div[@id='dropdown']//li//a[@href='/project/1/import']");
    final public SelenideElement configureProject = Selenide.$x("//div[@id='dropdown']//li//a[@href='/project/1']");
    final public SelenideElement manageProjects = Selenide.$x("//div[@id='dropdown']//li//a[@href='/projects']");

    public NewTaskBox openNewTaskBox() {
        this.addNewTask.click();
        return new NewTaskBox();
    }

    public ManageProjectsPage openManageProjectsPage() {
        this.manageProjects.click();
        return new ManageProjectsPage();
    }

}
