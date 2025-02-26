package dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProjectRs {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("announcement")
    @Expose
    private String announcement;
    @SerializedName("show_announcement")
    @Expose
    private Boolean showAnnouncement;
    @SerializedName("is_completed")
    @Expose
    private Boolean isCompleted;
    @SerializedName("completed_on")
    @Expose
    private Object completedOn;
    @SerializedName("suite_mode")
    @Expose
    private Integer suiteMode;
    @SerializedName("default_role_id")
    @Expose
    private Object defaultRoleId;
    @SerializedName("case_statuses_enabled")
    @Expose
    private Boolean caseStatusesEnabled;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("users")
    @Expose
    private List<Object> users;
    @SerializedName("groups")
    @Expose
    private List<Object> groups;
}
