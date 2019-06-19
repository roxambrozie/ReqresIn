package services.petshop.steps;


import io.restassured.response.Response;

import org.junit.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import services.petshop.pojo.requests.Pet;

public class CommonMethodsPetSteps {

    @Steps
    PostPetSteps postPetSteps;

    @Steps
    GetPetSteps getPetSteps;

    @Step("When I retrieve the id of the created pet")
    public void getTheIdOfTheCreatedPet(Pet mypet){
        Response createPetR = postPetSteps.createNewPet(mypet);
        Pet createdPet = createPetR.as(Pet.class);
        System.out.println(getPetSteps.getPetWithId(createdPet.getId()));
    }

    @Step("Then I check the status code of the response when I perform an action successfully is 200")
    public void statusCodeSuccess(Response response){
        Assert.assertEquals("The status is not 200 OK.",200, response.getStatusCode());
    }

    @Step("Assert the user that has been retrieved with the get method is the same user that has been created")
    public void assertUserRetrievedIsUserCreated(Pet mypet){
        Response createPetR = postPetSteps.createNewPet(mypet);
        Pet createdPet = createPetR.as(Pet.class);
        Assert.assertEquals(createdPet.getId(), mypet.getId());
    }



}
