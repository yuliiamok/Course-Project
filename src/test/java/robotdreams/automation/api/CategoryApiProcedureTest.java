package robotdreams.automation.api;

import robotdreams.automation.base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CategoryApiProcedureTest extends BaseApiTest {

    // Happy path

    @DataProvider(name = "createNewPCategoryData")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                {"Category 1", 1},
                {"Category 2", 2},
                {"Category 2", 3}
        };
    }

    @Test(dataProvider = "createNewPCategoryData", testName = "Create new category")
    public void testCreateCategory(String categoryName, int projectId) {

        String payload = jsonRpcPayload.category.createCategory(categoryName, projectId).toString();
        String response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then().statusCode(200)
                .extract().body().asPrettyString();

        System.out.println(response);
    }

// Add data provider with different parameters and add softAsserts
    // Create category duplicate and check that result is false
    // Create category for project id which does not exist and check that result is false
    // Create category for project id = 0 and check that result is false
}