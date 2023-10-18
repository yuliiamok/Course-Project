package robotdreams.automation.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import robotdreams.automation.api.controller.UserController;
import robotdreams.automation.app.api.pojo.RemoveObjectResponse;
import robotdreams.automation.base.BaseApiTest;

import static io.restassured.RestAssured.given;


public class UserApiProceduresTest extends BaseApiTest {

    @Test(testName = "Create new user")
    public void createNewUserTest() {

        String payload = jsonRpcPayload.user.createUser("Elvira", "123456").toString();
        String response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then().assertThat().statusCode(200)
                .extract().body().asPrettyString();
    }

    @Test(testName = "Get user by Name")
    public void getUserByNameTest() {

        String payload = jsonRpcPayload.user.getUserByName("Elvira").toString();
        String response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .get("/jsonrpc.php")
                .then().statusCode(200)
                .extract().body().asPrettyString();

    }

    @Test(testName = "Remove user by Id")
    public void removeUserTest() {

        int userId = new UserController().getUser("Elvira").getId();
        System.out.println("user_id is: " + userId);

        String payload = jsonRpcPayload.user.removeUser(userId).toString();
        RemoveObjectResponse response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .delete("/jsonrpc.php")
                .then().statusCode(200)
                .extract().body().as(RemoveObjectResponse.class);
    }
}
