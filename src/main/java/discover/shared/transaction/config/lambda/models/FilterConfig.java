
package discover.shared.transaction.config.lambda.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dailyMinCount",
    "interfaceId",
    "initiatedBy"
})
public class FilterConfig {

    @JsonProperty("dailyMinCount")
    private Integer dailyMinCount;
    @JsonProperty("interfaceId")
    private List<String> interfaceId = null;
    @JsonProperty("initiatedBy")
    private List<String> initiatedBy = null;

    @JsonProperty("dailyMinCount")
    public Integer getDailyMinCount() {
        return dailyMinCount;
    }

    @JsonProperty("dailyMinCount")
    public void setDailyMinCount(Integer dailyMinCount) {
        this.dailyMinCount = dailyMinCount;
    }

    public FilterConfig withDailyMinCount(Integer dailyMinCount) {
        this.dailyMinCount = dailyMinCount;
        return this;
    }

    @JsonProperty("interfaceId")
    public List<String> getInterfaceId() {
        return interfaceId;
    }

    @JsonProperty("interfaceId")
    public void setInterfaceId(List<String> interfaceId) {
        this.interfaceId = interfaceId;
    }

    public FilterConfig withInterfaceId(List<String> interfaceId) {
        this.interfaceId = interfaceId;
        return this;
    }

    @JsonProperty("initiatedBy")
    public List<String> getInitiatedBy() {
        return initiatedBy;
    }

    @JsonProperty("initiatedBy")
    public void setInitiatedBy(List<String> initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public FilterConfig withInitiatedBy(List<String> initiatedBy) {
        this.initiatedBy = initiatedBy;
        return this;
    }

}
