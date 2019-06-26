package services.petshop.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.petshop.PetShopService;
import services.petshop.pojo.requests.Pet;
import utils.reusable.specifications.ReusableSpecifications;

public class PostPetSteps {

    private PetShopService petShopService = new PetShopService();
    private String POST_CREATE_PET_URL = petShopService.getBaseUri() + PetShopService.PET_URI;

    @Step("Creating a new pet")
    public Response createNewPet(Pet pet) {
        Response response = SerenityRest.rest().given().log().all()
                .when()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .body(pet)
                .post(POST_CREATE_PET_URL);
        response.then().log().all();

        return response;
    }


}
