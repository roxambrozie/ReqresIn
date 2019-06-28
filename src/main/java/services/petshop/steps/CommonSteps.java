package services.petshop.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import services.petshop.pojo.Pet;
import services.petshop.pojo.responses.ErrorResponse;
import utils.methods.ReusableMethods;

public class CommonSteps {

    ReusableMethods reusableMethods = new ReusableMethods();

    @Step("Then I assert the pet that has been retrieved is the same pet that has been created")
    public void verifyPetEquals(Pet petCreated, Pet mypet) {
        Assert.assertEquals(petCreated, mypet);
    }

    public Pet convertResponseToPet(Response response) {
        return (response.as(Pet.class));
    }

    @Step("Then I verify the error message is {2}")
    public void verifyErrMsg(Response response, int statusCode, String expectedErrorMsg) {
        reusableMethods.validateResponseStatusCode(response, statusCode);
        ErrorResponse petNotFoundResponse = response.as(ErrorResponse.class);
        Assert.assertEquals(expectedErrorMsg, petNotFoundResponse.getMessage());
    }

    @Step("When I check the pet retrieved has the {1} name")
    public void verifyPetName(Response response, String name) {
        Pet pet = convertResponseToPet(response);
        Assert.assertEquals(name, pet.getName());
    }

    @Step("When I check the pet retrieved has the {1} status")
    public void verifyPetStatus(Response response, String status) {
        Pet pet = convertResponseToPet(response);
        Assert.assertEquals(status, pet.getStatus());
    }

    public Pet createValidPetObject(String name, String status) {
        int id = reusableMethods.generateRandomInt(10, 100);
        Pet myPet = new Pet();
        myPet.setId(id);
        myPet.setName(name);
        myPet.setStatus(status);

        return myPet;
    }
}
