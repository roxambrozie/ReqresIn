package petshop.post;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.petshop.pojo.Pet;
import services.petshop.steps.*;
import io.restassured.response.Response;
import services.petshop.utils.pet.constants.PetConstants;
import utils.methods.ReusableMethods;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "service", name = "Pet"),
        @WithTag(type = "type", name = "Regression")
})
public class FlowPetTest {

    private Pet myPet = new Pet();
    private Pet myUpdatedPet = new Pet();

    @Steps
    ReusableMethods reusableMethods;

    @Steps
    PostPetSteps postPetSteps;

    @Steps
    GetPetSteps getPetSteps;

    @Steps
    CommonSteps commonSteps;

    @Steps
    PutPetSteps putPetSteps;

    @Steps
    DeletePetSteps deletePetSteps;

    @Before
    public void createPrereq() {
        myPet.setId(2);
        myPet.setName("Animalut");
        myPet.setStatus("available");
        myUpdatedPet.setId(myPet.getId());
        myUpdatedPet.setName(myPet.getName());
        myUpdatedPet.setStatus("sold");
    }

    @Title("This is a test that will create a new pet, then will retrieve, update and delete it")
    @WithTag(type = "type", name = "E2E")
    @Test
    public void createGetUpdateDeletePet() {
        Response createdPetResponse = postPetSteps.createNewPet(myPet);
        reusableMethods.validateResponseStatusCode(createdPetResponse, 200);
        Pet createdPet = commonSteps.convertResponseToPet(createdPetResponse);
        Pet retrievedPet = commonSteps.convertResponseToPet(getPetSteps.getPetUsingId(createdPet.getId()));
        commonSteps.verifyPetEqual(retrievedPet, myPet);
        Response updatedPetResponse = putPetSteps.updatePet(myUpdatedPet);
        Pet updatedPet = commonSteps.convertResponseToPet(updatedPetResponse);
        commonSteps.verifyPetEqual(updatedPet, myUpdatedPet);
        Response responseForPetDeleted = deletePetSteps.deletePetUsingId(updatedPet.getId());
        reusableMethods.validateResponseStatusCode(responseForPetDeleted, 200);
        Response responseGetDeletedPet = getPetSteps.getPetUsingId(updatedPet.getId());
        commonSteps.verifyErrMsg(responseGetDeletedPet, 404, PetConstants.PET_NOT_FOUND);
    }


}
