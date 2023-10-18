package robotdreams.automation.base;

import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import robotdreams.automation.Config;
import robotdreams.automation.app.api.CourseJSONRPC;

import java.util.Map;

import static io.restassured.mapper.ObjectMapperType.GSON;

public class BaseApiTest extends BaseTestNG {

    final protected Logger logger = LogManager.getLogger(this.getClass());
    @BeforeMethod
    public void setFilters() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(new ObjectMapperConfig(GSON));
    }

    final protected CourseJSONRPC jsonRpcPayload = new CourseJSONRPC();
    public RequestSpecification request() {
        return this.request(null, null);
    }
    public RequestSpecification request(String username, String password) {
        username = username != null ? username : Config.API_USER_NAME.value;
        password = password != null ? password : Config.API_USER_PASSWORD.value;

        return RestAssured.given()
                .baseUri(Config.getApiBaseURL().toString())
                .auth()
                .basic(username, password);
    }

}
