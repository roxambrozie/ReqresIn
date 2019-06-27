package services.reqresin.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;
import services.reqresin.pojo.node.User;
import utils.reusable.specifications.ReusableSpecifications;

public class PostUserSteps {

    private ReqresService reqresService = new ReqresService();
    private String POST_CREATE_USER_URL = reqresService.getBaseUri() + ReqresService.POST_USER_URI;

    @Step("When I create a new user")
    public Response createUser(User user) {
        Response response = SerenityRest.rest().given().log().all()
                .when()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .body(user)
                .post(POST_CREATE_USER_URL);
        response.then().log().all();

        return response;
    }
}
