package robotdreams.automation.app.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetProjectResult extends Result {

    private String name;
    private int is_active;
    private String token;
    private String last_modified;
    private int is_public;
    private int is_private;
    private String default_swimlane;
    private int show_default_swimlane;
    private String description;
    private String identifier;
    private String start_date;
    private String end_date;
    private int owner_id;
    private int priority_default;
    private int priority_start;
    private int priority_end;
    private String email;
    private String predefined_email_subjects;
    private int per_swimlane_task_limits;
    private int task_limit;
    private int enable_global_tags;
    private String url;

}
