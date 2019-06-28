package services.reqresin.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;
import services.reqresin.pojo.node.Resource;
import services.reqresin.pojo.responses.GetResourceListResponse;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class GetResourceSteps {

    private ReqresService reqresService = new ReqresService();
    private String GET_RESOURCES_URL = reqresService.getBaseUri() + ReqresService.GET_RESOURCES_URI;
    private final Logger logger = Logger.getLogger(getClass().getCanonicalName());

    @Step("When I retrieve the list of resources")
    public Response getResourceList() {
        Response response = SerenityRest.rest().given().log().all()
                .baseUri(GET_RESOURCES_URL)
                .when()
                .get();
        response.then().log().all();

        return response;
    }

    @Step("When I retrieve a single resource from the list based on id")
    public Response getResourceFromListWithId(int id) {
        Response response = SerenityRest.rest().given().log().all()
                .baseUri(GET_RESOURCES_URL)
                .pathParam("id", id)
                .when()
                .get("/{id}");
        response.then().log().all();

        return response;
    }

    @Step("Then I check the resource with the name {1} exists")
    public void checkResourceWithNameExists(Response response, String name) {
        GetResourceListResponse getResourceResponse = response.as(GetResourceListResponse.class);
        List<Resource> resourceList = getResourceResponse.getData();
        List<Resource> result = resourceList.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList());
        for (Resource r : result) {
            logger.info(r.getName());
        }
        //result.forEach(Resource r  logger.info(r.getName()));
        assertThat(result, hasSize(1));
    }

    @Step("Then I check the resource with the color code {1} exists")
    public void checkResourceWithColorExists(Response response, String color) {
        GetResourceListResponse getResourceResponse = response.as(GetResourceListResponse.class);
        List<Resource> resourceList = getResourceResponse.getData();
        List<Resource> result = resourceList.stream().filter(user -> user.getColor().equals(color)).collect(Collectors.toList());
        assertThat(result, hasSize(1));
    }

    @Step("Then I check the resource with the year {1} exists")
    public void checkResourceWithYearExists(Response response, int year) {
        GetResourceListResponse getResourceResponse = response.as(GetResourceListResponse.class);
        List<Resource> resourceList = getResourceResponse.getData();
        List<Resource> result = resourceList.stream().filter(user -> user.getYear().equals(year)).collect(Collectors.toList());
        assertThat(result, hasSize(1));
    }

    @Step("Then I check the resource with the pantone value {1} exists")
    public void checkResourceWithPantoneValueExists(Response response, String pantone_value) {
        GetResourceListResponse getResourceResponse = response.as(GetResourceListResponse.class);
        List<Resource> resourceList = getResourceResponse.getData();
        List<Resource> result = resourceList.stream().filter(user -> user.getPantone_value().equals(pantone_value)).collect(Collectors.toList());
        assertThat(result, hasSize(1));
    }

    @Step("Then I check the resource with the id {1} exists")
    public void checkResourceWithIdExists(Response response, int id) {
        GetResourceListResponse getResourceResponse = response.as(GetResourceListResponse.class);
        List<Resource> resourceList = getResourceResponse.getData();
        List<Resource> result = resourceList.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList());
        assertThat(result, hasSize(1));
    }

}
