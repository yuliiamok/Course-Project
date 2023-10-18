package robotdreams.automation.app.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import robotdreams.automation.app.api.CourseJSONRPC;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"name", "email", "role"})
public class User {

    private String username;
    private String password;
    private String name;
    private String email;
    private String role;

    public JsonObject createUser(String username, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        return CourseJSONRPC.baseRequest("createUser", params);
    }

    public JsonObject getUserByName(String username) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        return CourseJSONRPC.baseRequest("getUserByName", params);
    }
    public JsonObject removeUser(int userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", userId);
        return CourseJSONRPC.baseRequest("removeUser", params);
    }
}
