package robotdreams.automation.api.controller;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import robotdreams.automation.app.api.CourseJSONRPC;
import robotdreams.automation.app.api.pojo.*;

public class UserController extends AbstractBaseController {


    public CreateResponse createUser(String username, String password) {
        String payload = jsonRpcPayload.user.createUser(username, password).toString();
        return (CreateResponse) this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php");

    }

    public Result getUser(String username) {
        String payload = new CourseJSONRPC().user.getUserByName(username).toString();
        return request()
                .contentType(ContentType.JSON)
                .body(payload)
                .get("/jsonrpc.php").as(Response.class).getResult();
    }

    public void deleteUser(int userId) {

        String payload = jsonRpcPayload.user.removeUser(userId).toString();
        request()
                .contentType(ContentType.JSON)
                .body(payload)
                .delete("/jsonrpc.php").as(RemoveObjectResponse.class);
    }
}

