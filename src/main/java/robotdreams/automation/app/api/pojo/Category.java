package robotdreams.automation.app.api.pojo;

import robotdreams.automation.app.api.CourseJSONRPC;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class Category {

    public JsonObject createCategory(String categoryName, Integer projectId) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", categoryName);
        params.put("project_id", projectId);
        return CourseJSONRPC.baseRequest("createCategory", params);
    }
}
