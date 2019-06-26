package petshop.post;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.petshop.pojo.requests.Pet;
import services.petshop.steps.CommonMethodsPetSteps;
import services.petshop.steps.DeletePetSteps;
import services.petshop.steps.GetPetSteps;
import services.petshop.steps.PutPetSteps;
import io.restassured.response.Response;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "FlowPet")
})
public class FlowPetTest {

    private Pet mypet = new Pet();
    private Pet updatedPet = new Pet();

    @Steps
    GetPetSteps getPetSteps;

    @Steps
    CommonMethodsPetSteps commonMethodsPetSteps;

    @Steps
    PutPetSteps putPetSteps;

    @Steps
    DeletePetSteps deletePetSteps;

    @Before
    public void createPrereq() {
        mypet.setId(133);
        mypet.setName("Animalut");
        mypet.setStatus("available");
        updatedPet.setId(mypet.getId());
        updatedPet.setName(mypet.getName());
        updatedPet.setStatus("sold");

    }

    @Title("This is a test that will create a new pet, will perform a get method to retrieve it and a put method to update it")
    @Test
    public void createGetUpdatePet() {

        int id = commonMethodsPetSteps.createPetAndGetItsId(mypet);
        Response response = getPetSteps.getPetUsingId(id);
        commonMethodsPetSteps.statusCode(response, 200);
        commonMethodsPetSteps.assertPetRetrievedIsPetCreated(mypet.getId(), mypet.getName());
        putPetSteps.updatePet(updatedPet);
        commonMethodsPetSteps.assertPetStatusUpdated(updatedPet.getId(), updatedPet.getStatus());
        Response responseForPetDeleted = deletePetSteps.deletePetUsingId(id);
        commonMethodsPetSteps.statusCode(responseForPetDeleted, 200);

    }

}
