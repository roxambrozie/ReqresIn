package services.petshop.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.petshop.PetShopService;

public class GetPetSteps {

    PetShopService petShopService = new PetShopService();
    private String GET_PET_URL = petShopService.getBaseUri() + PetShopService.PET_URI;

    @Step("When I retrieve a single pet based on id {0}")
    public Response getPetUsingId(int id) {
        Response response = SerenityRest.rest().given().log().all()
                .baseUri(GET_PET_URL)
                .pathParam("id", id)
                .when()
                .get("/{id}");
        response.then().log().all();

        return response;
    }


}
