package robotdreams.automation.api;

import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import robotdreams.automation.api.controller.ProjectController;
import robotdreams.automation.app.api.pojo.*;
import robotdreams.automation.base.BaseApiTest;

public class ProjectApiProceduresTest extends BaseApiTest {

    @DataProvider(name = "createNewProjectData")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                {Project.newBuilder()
                        .setName("AI")
                        .build()},
                {Project.newBuilder()
                        .setName("Big Data")
                        .setDescription("Test desc")
                        .build()},
                {Project.newBuilder()
                        .setName("Data Visualization")
                        .setDescription("The project implements data visualization using different widgets")
                        .setOwner_id(1)
                        .setIdentifier("Visualization")
                        .setEnd_date("2022-07-10")
                        .setStart_date("2023-07-10")
                        .build()},
        };
    }

    @Test(dataProvider = "createNewProjectData", testName = "Create new project")
    public void createNewProjectTest(Project project) {
        String payload = jsonRpcPayload.project.createProject(String.valueOf(project)).toString();
        CreateResponse response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(CreateResponse.class);
    }

    @Test(testName = "Check that project with empty name cannot be created")
    public void negativeCreateNewProjectTest() {

        String payload = jsonRpcPayload.project.createProject("").toString();
        FailedResponse response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then()
                .assertThat().extract().body().as(FailedResponse.class);
    }

   @Test(testName = "Get project by name")
    public void getProjectByNameTest() {

        String payload = jsonRpcPayload.project.getProjectByName("Data Visualization").toString();
        GetProjectResponse response = this.request()
               .contentType(ContentType.JSON)
               .body(payload)
               .get("/jsonrpc.php").then()
               .assertThat().extract().response().path("name", "Data Visualization");
    }

    @Test(testName = "Delete project by id")
    public void removeProjectTest() {

        int projectId = new ProjectController().getProject("Data Visualization");
        System.out.println("project_id is: " + projectId);

        String payload = jsonRpcPayload.project.removeProject(projectId).toString();
        RemoveObjectResponse response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .delete("/jsonrpc.php")
                .then().statusCode(200)
                .extract().response().body().as(RemoveObjectResponse.class);
    }
}
