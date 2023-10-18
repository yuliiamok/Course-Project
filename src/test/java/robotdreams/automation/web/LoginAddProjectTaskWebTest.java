package robotdreams.automation.web;

import org.testng.Assert;
import org.testng.annotations.Test;
import robotdreams.automation.app.web.*;
import robotdreams.automation.base.BaseGUITest;

public class LoginAddProjectTaskWebTest extends BaseGUITest {

    @Test(testName = "Login and create new project with adding new task")
            //, groups = {"smoke", "regression"})
    public void LoginAddProjectTest() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.login("admin", "admin");
        dashboardPage.confirm();
        System.out.println("User is logged");

        dashboardPage = new DashboardPage();
        NewProjectBox newProjectBox = dashboardPage.openProjectBox();
        Assert.assertTrue(newProjectBox.isPageLoaded(), "Project box is not displayed");
        System.out.println("New project box is opened");

        newProjectBox = new NewProjectBox();
        ProjectPage projectPage = newProjectBox.addedProjectPage("Project 100");
        projectPage.confirm();
        System.out.println("New project is created");

        projectPage = new ProjectPage();
        NewTaskBox newTaskBox = projectPage.openSubmenuDropdown().openNewTaskBox();
        Assert.assertTrue(newTaskBox.isPageLoaded(), "Task box is not displayed");
        System.out.println("New task box is opened");

        newTaskBox = new NewTaskBox();
        projectPage = newTaskBox.addTask("Task 1");
        projectPage.confirm();

    }
}
