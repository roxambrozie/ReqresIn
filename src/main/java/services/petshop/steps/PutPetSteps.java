package services.petshop.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.petshop.PetShopService;
import services.petshop.pojo.Pet;
import utils.reusable.specifications.ReusableSpecifications;

public class PutPetSteps {

    private PetShopService petShopService = new PetShopService();
    private String PUT_PET_URL = petShopService.getBaseUri() + PetShopService.PET_URI;

    @Step("When I update the recently created pet")
    public Response updatePet(Pet pet){
        Response response = SerenityRest.rest().given().log().all()
                .when()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .body(pet)
                .put(PUT_PET_URL);
        response.then().log().all();

        return response;
    }
}
