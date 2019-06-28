package services.reqresin.pojo.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"name", "job"})
public class UserJobRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;

    public UserJobRequest() {
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("job")
    public String getJob() {
        return this.job;
    }

    @JsonProperty("job")
    public void setJob(String job) {
        this.job = job;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.name).append(this.job).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof UserJobRequest)) {
            return false;
        } else {
            UserJobRequest rhs = (UserJobRequest)other;
            return (new EqualsBuilder()).append(this.name, rhs.name).append(this.job, rhs.job).isEquals();
        }
    }
}
