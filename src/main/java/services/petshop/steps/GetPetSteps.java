package services.petshop.steps;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.petshop.PetShopService;
import services.petshop.pojo.requests.Pet;
import utils.reusable.specifications.ReusableSpecifications;

public class GetPetSteps {

    PetShopService petShopService = new PetShopService();
    private String GET_PET_URL = petShopService.getBaseUri() + PetShopService.GET_PET;

    @Step("When I retrieve a single pet based on id {0}")
    public Response getPetWithId(int id) {
        Response response = SerenityRest.rest().given().log().all()
                .get(GET_PET_URL + id);
        response.then().log().all();

        return response;
    }


}
