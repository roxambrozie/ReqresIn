package services.petshop.pojo;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import services.petshop.pojo.node.Category;
import services.petshop.pojo.node.Tag;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"id", "category", "name", "photoUrls", "tags", "status"})
public class Pet {
    @JsonProperty("id")
    private int id;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls = new ArrayList();
    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList();
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public Pet() {
    }

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return this.category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("photoUrls")
    public List<String> getPhotoUrls() {
        return this.photoUrls;
    }

    @JsonProperty("photoUrls")
    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return this.tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @JsonProperty("status")
    public String getStatus() {
        return this.status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
        return (new HashCodeBuilder()).append(this.id).append(this.category).append(this.name).append(this.photoUrls)
                .append(this.tags).append(this.status).append(this.additionalProperties).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof Pet)) {
            return false;
        } else {
            Pet rhs = (Pet)other;
            return (new EqualsBuilder()).append(this.id, rhs.id).append(this.category, rhs.category).append(this.name, rhs.name).append(this.photoUrls, rhs.photoUrls).append(this.tags, rhs.tags).append(this.status, rhs.status)
                    .append(this.additionalProperties, rhs.additionalProperties).isEquals();
        }
    }
}
