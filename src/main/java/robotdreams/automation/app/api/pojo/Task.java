package robotdreams.automation.app.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.JsonObject;
import lombok.*;
import robotdreams.automation.app.api.CourseJSONRPC;

import java.util.HashMap;
import java.util.Map;


@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"color_id", "column_id", "owner_id",
        "creator_id", "date_due", "description", "category_id",
        "swimlane_id", "priority", "recurrence_status",
        "recurrence_trigger", "recurrence_factor", "recurrence_timeframe",
        "reference", "tags", "date_started"})
public class Task {

    private String title;
    private int project_id;
    private String color_id;
    private int column_id;
    private int owner_id;
    private int creator_id;
    private String date_due;
    private String description;
    private int category_id;
    private int swimlane_id;
    private int priority;
    private int recurrence_status;
    private int recurrence_trigger;
    private int recurrence_factor;
    private int recurrence_timeframe;
    private String reference;
    private String tags;
    private String date_started;

    public JsonObject createTask(String title, int project_id) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("project_id", project_id);
        params.put("color_id", color_id);
        params.put("column_id", column_id);
        params.put("creator_id", creator_id);
        params.put("date_due", date_due);
        params.put("description", description);
        params.put("category_id", category_id);
        params.put("swimlane_id", swimlane_id);
        params.put("priority", priority);
        params.put("recurrence_status", recurrence_status);
        params.put("recurrence_trigger", recurrence_trigger);
        params.put("recurrence_factor", recurrence_factor);
        params.put("recurrence_timeframe", recurrence_timeframe);
        params.put("reference", reference);
        params.put("tags", tags);
        params.put("date_started", date_started);
        return CourseJSONRPC.baseRequest("createTask", params);
    }
    public JsonObject getTaskById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("task_id", id);
        return CourseJSONRPC.baseRequest("getTask", params);
    }

    public JsonObject openTask(int taskId) {
        Map<String, Object> params = new HashMap<>();
        params.put("task_id", taskId);
        return CourseJSONRPC.baseRequest("openTask", params);
    }
    public JsonObject updateTask(int id, String color_id, String description) {
        Map<String, Object> params = new HashMap<>();
        params.put("task_id", id);
        params.put("color_id", color_id);
        params.put("description", description);
        return CourseJSONRPC.baseRequest("updateTask", params);
    }
    public JsonObject removeTask(int taskId) {
        Map<String, Object> params = new HashMap<>();
        params.put("task_id", taskId);
        return CourseJSONRPC.baseRequest("removeTask", params);
    }

}
