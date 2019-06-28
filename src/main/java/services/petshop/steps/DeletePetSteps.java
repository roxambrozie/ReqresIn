package services.petshop.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.petshop.PetShopService;

public class DeletePetSteps {

    PetShopService petShopService = new PetShopService();
    private String DELETE_PET_URL = petShopService.getBaseUri() + PetShopService.PET_URI;

    @Step("When I delete a single pet based on id {0}")
    public Response deletePetUsingId(int id) {
        Response response = SerenityRest.rest().given().log().all()
                .baseUri(DELETE_PET_URL)
                .pathParam("id", id)
                .when()
                .delete("/{id}");
        response.then().log().all();

        return response;
    }
}
