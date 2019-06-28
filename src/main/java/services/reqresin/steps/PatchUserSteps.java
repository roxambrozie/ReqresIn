package services.reqresin.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;
import services.reqresin.pojo.requests.UserJobRequest;

public class PatchUserSteps {

    private ReqresService reqresService = new ReqresService();
    private String PATCH_USER_URL = reqresService.getBaseUri() + ReqresService.USERS_URI;

    @Step("When I update an attribute of the user")
    public Response patchUser(UserJobRequest user, int id) {

        Response response = SerenityRest.rest().given().log().all()
                .baseUri(PATCH_USER_URL)
                .pathParam("id", id)
                .when()
                .body(user)
                .patch("/{id}");
        response.then().log().all();

        return response;
    }
}
