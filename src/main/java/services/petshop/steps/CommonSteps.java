package services.petshop.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import services.petshop.pojo.Pet;
import services.petshop.pojo.responses.GetPetNotFoundResponse;
import utils.methods.ReusableMethods;


public class CommonSteps {

    ReusableMethods reusableMethods = new ReusableMethods();

    @Step("Then I assert the pet that has been retrieved is the same pet that has been created")
    public void verifyPetEqual(Pet petCreated, Pet mypet) {
        Assert.assertEquals(petCreated, mypet);
    }

    public Pet convertResponseToPet(Response response){
        Pet pet = response.as(Pet.class);
        return  pet;
    }

    @Step("Then I verify the error message is {2}")
    public void verifyErrMsg(Response response, int statusCode, String expectedErrorMsg) {
        reusableMethods.validateResponseStatusCode(response, statusCode);
        GetPetNotFoundResponse petNotFoundResponse = response.as(GetPetNotFoundResponse.class);
        Assert.assertEquals(expectedErrorMsg, petNotFoundResponse.getMessage());
    }

    @Step("When I check the pet retrieved has the {1} name")
    public void verifyPetName(Response response, String name){
        Pet pet = convertResponseToPet(response);
        Assert.assertEquals(name, pet.getName());
    }

    @Step("When I check the pet retrieved has the {1} status")
    public void verifyPetStatus(Response response, String status){
        Pet pet = convertResponseToPet(response);
        Assert.assertEquals(status, pet.getStatus());
    }

}
