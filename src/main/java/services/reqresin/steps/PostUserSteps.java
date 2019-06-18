package services.reqresin.steps.ReqresSteps;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;
import services.reqresin.pojo.node.User;
import utils.reusable.specifications.ReusableSpecifications;

public class PostUserSteps {

    private ReqresService reqresService = new ReqresService();
    private String POST_CREATE_USER_URL = reqresService.getBaseUri() + ReqresService.POST_CREATE_USER;


    @Step("Creating a new user with {0} name and {1} job.")
    public ValidatableResponse createUser(String name, String job) {

        User user = new User();
        user.setName(name);
        user.setJob(job);

        return SerenityRest.rest().given()
                .when()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .body(user)
                .post(POST_CREATE_USER_URL)
                .then()
                ;
    }


}
