
package discover.shared.transaction.config.lambda.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aggegrationPeriod",
    "retentionPeriod",
    "filterConfig",
    "outputLocation"
})
public class AggregationConfig {

    @JsonProperty("aggegrationPeriod")
    private int aggegrationPeriod;
    @JsonProperty("retentionPeriod")
    private int retentionPeriod;
    @JsonProperty("filterConfig")
    private FilterConfig filterConfig;
    @JsonProperty("outputLocation")
    private String outputLocation;

    @JsonProperty("aggegrationPeriod")
    public int getAggegrationPeriod() {
        return aggegrationPeriod;
    }

    @JsonProperty("aggegrationPeriod")
    public void setAggegrationPeriod(int aggegrationPeriod) {
        this.aggegrationPeriod = aggegrationPeriod;
    }

    public AggregationConfig withAggegrationPeriod(int aggegrationPeriod) {
        this.aggegrationPeriod = aggegrationPeriod;
        return this;
    }

    @JsonProperty("retentionPeriod")
    public int getRetentionPeriod() {
        return retentionPeriod;
    }

    @JsonProperty("retentionPeriod")
    public void setRetentionPeriod(int retentionPeriod) {
        this.retentionPeriod = retentionPeriod;
    }

    public AggregationConfig withRetentionPeriod(Integer retentionPeriod) {
        this.retentionPeriod = retentionPeriod;
        return this;
    }

    @JsonProperty("filterConfig")
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    @JsonProperty("filterConfig")
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public AggregationConfig withFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        return this;
    }

    @JsonProperty("outputLocation")
    public String getOutputLocation() {
        return outputLocation;
    }

    @JsonProperty("outputLocation")
    public void setOutputLocation(String outputLocation) {
        this.outputLocation = outputLocation;
    }

    public AggregationConfig withOutputLocation(String outputLocation) {
        this.outputLocation = outputLocation;
        return this;
    }

}
