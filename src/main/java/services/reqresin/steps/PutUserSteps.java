package services.reqresin.steps;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;
import services.reqresin.pojo.node.User;

public class PutUserSteps {

    private ReqresService reqresService = new ReqresService();
    private String PUT_USER_URL = reqresService.getBaseUri() + ReqresService.PUT_USER_UPDATE;

    @Step("Updating a user with {0} name and {1} job.")
    public ValidatableResponse updateUser(String name, String job, int id) {
        User user = new User();
        user.setName(name);
        user.setJob(job);

        return SerenityRest.rest().given()
                .when()
                .body(user)
                .put(PUT_USER_URL + id)
                .then();
    }

}
