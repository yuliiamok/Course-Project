package robotdreams.automation.api.controller;

import io.restassured.http.ContentType;
import robotdreams.automation.app.api.CourseJSONRPC;
import robotdreams.automation.app.api.pojo.*;

public class ProjectController extends AbstractBaseController {


    public int getProject(String name) {
        String payload = new CourseJSONRPC().project.getProjectByName(name).toString();
        return request()
                .contentType(ContentType.JSON)
                .body(payload)
                .get("/jsonrpc.php").then().extract().body().path("id");
    }

}
