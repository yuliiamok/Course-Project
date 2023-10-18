package robotdreams.automation.app.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetProjectResponse {


    private String jsonrpc = "2.0";
    private int id;
    private GetProjectResult getProjectResult;
}
