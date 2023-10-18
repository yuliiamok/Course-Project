package robotdreams.automation.api.controller;

import io.restassured.http.ContentType;
import robotdreams.automation.app.api.CourseJSONRPC;
import robotdreams.automation.app.api.pojo.RemoveObjectResponse;
import robotdreams.automation.app.api.pojo.Response;
import robotdreams.automation.app.api.pojo.Result;
import robotdreams.automation.app.api.pojo.UpdatedTaskResult;

public class TaskController extends AbstractBaseController {

    public Result getTask(int id) {
        String payload = new CourseJSONRPC().task.getTaskById(id).toString();
        return request()
                .contentType(ContentType.JSON)
                .body(payload)
                .get("/jsonrpc.php").as(Response.class).getResult();
    }
}
