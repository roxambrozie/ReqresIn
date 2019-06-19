package petshop.post;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.petshop.pojo.requests.Pet;
import services.petshop.steps.CommonMethodsPetSteps;
import services.petshop.steps.PostPetSteps;
import services.petshop.steps.PutPetSteps;


@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "FlowPet")
})
public class FlowPetTest {

    private Pet mypet = new Pet();
    private Pet updatedPet = new Pet();

    @Steps
    PostPetSteps postPetSteps;

    @Steps
    CommonMethodsPetSteps commonMethodsPetSteps;

    @Steps
    PutPetSteps putPetSteps;

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

        Response createPetR = postPetSteps.createNewPet(mypet);
        commonMethodsPetSteps.statusCodeSuccess(createPetR);
        commonMethodsPetSteps.getTheIdOfTheCreatedPet(mypet);
        commonMethodsPetSteps.assertUserRetrievedIsUserCreated(mypet);
        putPetSteps.updatePet(updatedPet);

    }

}
