package robotdreams.automation.web;

import org.testng.Assert;
import org.testng.annotations.Test;
import robotdreams.automation.app.web.DashboardPage;
import robotdreams.automation.app.web.ManageProjectsPage;
import robotdreams.automation.app.web.NewProjectBox;
import robotdreams.automation.app.web.ProjectPage;
import robotdreams.automation.base.BaseGUITest;

public class ProjectWebProceduresTest extends BaseGUITest {


    @Test(testName = "Open project box")
    public void openNewProjectBox() {
        DashboardPage dashboardPage = new DashboardPage();
        NewProjectBox newProjectBox = dashboardPage.openProjectBox();
        Assert.assertTrue(newProjectBox.isPageLoaded(), "Project box is not displayed");
    }
    @Test(testName = "Add new project", groups = {"smoke", "regression"})
    public void addNewProjectTest() {
        NewProjectBox newProjectBox = new NewProjectBox();
        ProjectPage projectPage = newProjectBox.addedProjectPage("Project 1");
        projectPage.confirm();
    }

    @Test(testName = "Project page is opened after adding new project")
    public void checkProjectPageIsOpenedAfterAddingProjectTest() {
        ProjectPage projectPage = new ProjectPage();
        ManageProjectsPage manageProjectsPage = projectPage.openSubmenuDropdown().openManageProjectsPage();
        manageProjectsPage.confirm();
    }
}
