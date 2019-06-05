package services.reqresin.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;

public class DeleteUserSteps {

    ReqresService reqresService = new ReqresService();
    private String DELETE_SINGLE_USER_URL = reqresService.getBaseUri() + ReqresService.DELETE_USER;

    @Step("When I delete a single user from the list based on id")
    public Response deleteUserFromListWithId(int id) {
        Response response = SerenityRest.rest().given().log().all()
                .delete(DELETE_SINGLE_USER_URL + id);
        response.then().log().all();

        return response;
    }
}
