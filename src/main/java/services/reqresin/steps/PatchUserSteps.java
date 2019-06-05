package services.reqresin.steps;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;
import services.reqresin.pojo.node.User;

public class PatchUserSteps {

    private ReqresService reqresService = new ReqresService();
    private String PUT_USER_URL = reqresService.getBaseUri() + ReqresService.PUT_USER_UPDATE;

    @Step("Creating a new user with {0} name and {1} job.")
    public ValidatableResponse patchUser(String job, int id) {

        User user = new User();
        user.setJob(job);

        return SerenityRest.rest().given()
                .when()
                .body(user)
                .patch(PUT_USER_URL)
                .then();
    }
}
