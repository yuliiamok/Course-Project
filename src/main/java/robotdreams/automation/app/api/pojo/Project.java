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
@JsonIgnoreProperties({"description", "owner_id", "identifier", "start_date", "end_date"})
public class Project {

    private String name;
    private String description;
    private int owner_id;
    private String identifier;
    private String start_date;
    private String end_date;

    public static Builder newBuilder() {return new Project().new Builder(); }

    public class Builder {
        protected Builder() {
        }
        public Project.Builder setName(String name){
            Project.this.name = name;
            return this;
        }
        public Builder setDescription(String description){
            Project.this.description = description;
            return this;
        }
        public Builder setOwner_id(int owner_id){
            Project.this.owner_id = owner_id;
            return this;
        }
        public Builder setIdentifier(String identifier){
            Project.this.identifier = identifier;
            return this;
        }
        public Builder setStart_date(String start_date){
            Project.this.start_date = start_date;
            return this;
        }
        public Builder setEnd_date(String end_date){
            Project.this.end_date = end_date;
            return this;
        }

        public Project build() {
            return Project.this;
        }
    }

    public JsonObject createProject(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("description", description);
        params.put("owner_id", owner_id);
        params.put("identifier", identifier);
        params.put("start_date", start_date);
        params.put("end_date", end_date);
        return CourseJSONRPC.baseRequest("createProject", params);
    }
    public JsonObject getProjectByName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return CourseJSONRPC.baseRequest("getProjectByName", params);
    }

    public JsonObject removeProject(int projectId) {
        Map<String, Object> params = new HashMap<>();
        params.put("project_id", projectId);
        return CourseJSONRPC.baseRequest("removeProject", params);
    }
}
