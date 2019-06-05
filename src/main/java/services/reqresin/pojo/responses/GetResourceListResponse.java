package services.reqresin.pojo.responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import services.reqresin.pojo.node.Resource;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "per_page",
        "total",
        "total_pages",
        "data"
})

public class GetResourceListResponse {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer per_page;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer total_pages;
    @JsonProperty("data")
    private List<Resource> data = new ArrayList<Resource>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("per_page")
    public Integer getPer_page() {
        return per_page;
    }

    @JsonProperty("per_page")
    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("total_pages")
    public Integer getTotal_pages() {
        return total_pages;
    }

    @JsonProperty("total_pages")
    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    @JsonProperty("data")
    public List<Resource> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Resource> data) {
        this.data = data;
    }

    @Override
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(page).append(per_page).append(total).append(total_pages).append(data).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetResourceListResponse) == false) {
            return false;
        }
        GetResourceListResponse rhs = ((GetResourceListResponse) other);
        return new EqualsBuilder().append(page, rhs.page).append(per_page, rhs.per_page).append(total, rhs.total).append(total_pages, rhs.total_pages).append(data, rhs.data).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
