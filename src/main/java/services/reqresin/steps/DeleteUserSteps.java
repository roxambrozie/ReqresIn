package services.reqresin.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;

public class DeleteUserSteps {

    ReqresService reqresService = new ReqresService();
    private String DELETE_USER_URL = reqresService.getBaseUri() + ReqresService.POST_USER_URI;

    @Step("When I delete a single user from the list based on id")
    public Response deleteUserFromListWithId(int id) {
        Response response = SerenityRest.rest().given().log().all()
                .baseUri(DELETE_USER_URL)
                .pathParam("id", id)
                .when()
                .delete("/{id}");
        response.then().log().all();

        return response;
    }
}
