package services.reqresin.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;
import services.reqresin.pojo.requests.UserJobRequest;

public class PutUserSteps {

    private ReqresService reqresService = new ReqresService();
    private String PUT_USER_URL = reqresService.getBaseUri() + ReqresService.GET_USERS_URI;

    @Step("When I update a user")
    public Response updateUser(UserJobRequest user, int id) {

        Response response = SerenityRest.rest().given().log().all()
                .baseUri(PUT_USER_URL)
                .pathParam("id", id)
                .when()
                .body(user)
                .put("/{id}");
        response.then().log().all();

        return response;
    }

}
