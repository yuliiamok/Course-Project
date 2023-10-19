package robotdreams.automation.web;

import org.testng.annotations.Test;
import robotdreams.automation.app.web.NewTaskBox;
import robotdreams.automation.app.web.ProjectPage;
import robotdreams.automation.base.BaseGUITest;

public class TaskWebProcedureTest extends BaseGUITest {
    @Test(testName = "Add new task to a project")
    public void addNewTaskTest() {
        NewTaskBox newTaskBox = new NewTaskBox();
        ProjectPage projectPage = newTaskBox.addTask("Task 1");
        projectPage.confirm();
    }
}
