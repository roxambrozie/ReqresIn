package services.reqresin.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;
import services.reqresin.pojo.requests.UserJobRequest;

public class PatchUserSteps {

    private ReqresService reqresService = new ReqresService();
    private String PUT_USER_URL = reqresService.getBaseUri() + ReqresService.POST_USER_URI;

    @Step("When I create a new user")
    public Response patchUser(String job, int id) {

        UserJobRequest user = new UserJobRequest();
        user.setJob(job);

        Response response = SerenityRest.rest().given().log().all()
                .baseUri(PUT_USER_URL)
                .pathParam("id", id)
                .when()
                .body(user)
                .patch("/{id}");
        response.then().log().all();

        return response;
    }
}
