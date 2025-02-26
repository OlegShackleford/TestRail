package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectRq {

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
    @SerializedName("suite_mode")
    @Expose
    private Integer suiteMode;

}
