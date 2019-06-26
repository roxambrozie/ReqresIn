package services.petshop.steps;


import io.restassured.response.Response;

import org.junit.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import services.petshop.pojo.requests.Pet;
import utils.methods.ReusableMethods;

public class CommonMethodsPetSteps {

    ReusableMethods reusableMethods = new ReusableMethods();

    @Steps
    PostPetSteps postPetSteps;

    @Steps
    GetPetSteps getPetSteps;

    @Step("When I create a new pet and retrieve the id of the created pet")
    public int createPetAndGetItsId(Pet mypet) {
        Response createPetR = postPetSteps.createNewPet(mypet);
        Pet createdPet = createPetR.as(Pet.class);
        return createdPet.getId();
    }

    @Step("Then I check the status code of the response when I perform this action is {1}")
    public void statusCode(Response response, int statusCode) {
        reusableMethods.validateResponseStatusCode(response, statusCode);
    }

    @Step("Then I assert the pet that has been retrieved with the get method is the same pet that has been created")
    public void assertPetRetrievedIsPetCreated(int id, String name) {
        Pet pet = getPetSteps.getPetUsingId(id).as(Pet.class);
        Assert.assertEquals(pet.getName(), name);
    }

    @Step("Then I assert the pet status has been updated")
    public void assertPetStatusUpdated(int id,String status){
        Pet pet = getPetSteps.getPetUsingId(id).as(Pet.class);
        Assert.assertEquals(pet.getStatus(), status);
    }


}
