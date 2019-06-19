package services.petshop.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.petshop.PetShopService;
import services.petshop.pojo.requests.Pet;
import utils.reusable.specifications.ReusableSpecifications;

public class PutPetSteps {

    private PetShopService petShopService = new PetShopService();
    private String PUT_PET_URL = petShopService.getBaseUri() + PetShopService.POST_PET;

    Pet pet = new Pet();

    @Step("Updating the recently created pet")
    public Response updatePet(Pet pet){
        return SerenityRest.rest().given()
                .when()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .body(pet)
                .put(PUT_PET_URL);
    }
}
