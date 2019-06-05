package services.reqresin.pojo.node;
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
@JsonPropertyOrder({"id", "name", "year", "color", "pantone_value"})
public class Resource {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("color")
    private String color;
    @JsonProperty("pantone_value")
    private String pantone_value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public Resource() {
    }

    @JsonProperty("id")
    public Integer getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return this.year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("color")
    public String getColor() {
        return this.color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("pantone_value")
    public String getPantone_value() {
        return this.pantone_value;
    }

    @JsonProperty("pantone_value")
    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public int hashCode() {
        return (new HashCodeBuilder()).append(this.id).append(this.name).append(this.year).append(this.color).append(this.pantone_value).append(this.additionalProperties).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof Resource)) {
            return false;
        } else {
            Resource rhs = (Resource)other;
            return (new EqualsBuilder()).append(this.id, rhs.id).append(this.name, rhs.name).append(this.year, rhs.year).append(this.color, rhs.color).append(this.pantone_value, rhs.pantone_value).append(this.additionalProperties, rhs.additionalProperties).isEquals();
        }
    }

}
