package robotdreams.automation.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import robotdreams.automation.api.controller.TaskController;
import robotdreams.automation.app.api.pojo.FailedResponse;
import robotdreams.automation.app.api.pojo.UpdatedTaskResult;
import robotdreams.automation.base.BaseApiTest;

public class TaskApiProceduresTest extends BaseApiTest {

    @Test(testName = "Create new <task1>")
    public void createNewTaskTest1() {

        String payload = jsonRpcPayload.task.createTask("Task 65.1", 65).toString();
        String response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then().statusCode(200)
                .extract().body().asPrettyString();
    }
    @Test(testName = "Create new <task2>")
    public void createNewTaskTest2() {
        String payload = jsonRpcPayload.task.createTask("Task 65.2", 65).toString();
        String response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then().statusCode(200)
                .extract().body().asPrettyString();
    }

    @Test(testName = "Check that task with empty name cannot be created")
    public void negativeCreateNewTaskWithEmptyNameTest() {

        String payload = jsonRpcPayload.task.createTask("", 65).toString();
        FailedResponse response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then()
                .assertThat().extract().body().as(FailedResponse.class);
    }
    @Test(testName = "Check that task with project_id=0 cannot be created")
    public void negativeCreateNewTaskWithZeroProjectIdTest() {

        String payload = jsonRpcPayload.task.createTask("Test", 0).toString();
        FailedResponse response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then()
                .assertThat().extract().body().as(FailedResponse.class);
    }
    @Test(testName = "Check that duplicated task cannot be created")
    public void negativeDuplicateTaskTest() {

        String payload = jsonRpcPayload.task.createTask("Task 65.2", 65).toString();
        FailedResponse response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then()
                .assertThat().extract().body().as(FailedResponse.class);
    }

    @Test(testName = "Get task by id")
    public void getTaskByIdTest() {

        String payload = jsonRpcPayload.task.getTaskById(10).toString();
        String response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .get("/jsonrpc.php")
                .then().statusCode(200)
                .extract().body().asPrettyString();
    }

    @Test(testName = "Update task by id")
    public void updateTask() {
        String payload = jsonRpcPayload.task.updateTask(10, "yellow", "Updated task").toString();
        UpdatedTaskResult response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .patch("/jsonrpc.php")
                .then()
                .assertThat().extract().body().as(UpdatedTaskResult.class);
    }
    @Test(testName = "Open the task by id")
    public void openTaskTest() {
        String payload = jsonRpcPayload.task.openTask(10).toString();
        UpdatedTaskResult response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then()
                .assertThat().extract().body().as(UpdatedTaskResult.class);
    }

    @Test(testName = "Remove the task by id")
    public void removeTaskTest() {
        int taskId = new TaskController().getTask(10).getId();

        String payload = jsonRpcPayload.task.removeTask(taskId).toString();
        UpdatedTaskResult response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .delete("/jsonrpc.php")
                .then().statusCode(200)
                .extract().body().as(UpdatedTaskResult.class);
    }
}
