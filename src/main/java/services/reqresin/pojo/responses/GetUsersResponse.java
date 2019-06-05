
package services.reqresin.pojo.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import services.reqresin.pojo.node.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "per_page",
        "total",
        "total_pages",
        "data"
})
public class GetUsersResponse {

    @JsonProperty("page")
    private int page;
    @JsonProperty("per_page")
    private int per_page;
    @JsonProperty("total")
    private int total;
    @JsonProperty("total_pages")
    private int total_pages;
    @JsonProperty("data")
    private List<User> data;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(page).append(per_page).append(total).append(total_pages).append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetUsersResponse) == false) {
            return false;
        }
        GetUsersResponse rhs = ((GetUsersResponse) other);
        return new EqualsBuilder().append(page, rhs.page).append(per_page, rhs.per_page).append(total, rhs.total).append(total_pages, rhs.total_pages).append(data, rhs.data).isEquals();
    }

}
