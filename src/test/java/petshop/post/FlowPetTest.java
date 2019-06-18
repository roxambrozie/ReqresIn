package petshop.post;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.petshop.pojo.requests.Pet;
import services.petshop.steps.GetPetSteps;
import services.petshop.steps.PostPetSteps;
import services.petshop.steps.PutPetSteps;
import services.reqresin.steps.GetUserSteps;
import services.reqresin.steps.PutUserSteps;


@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "PostPet")
})
public class PostPetTest {
    Pet mypet;
    @Steps
    PostPetSteps postPetSteps;

    @Steps
    GetPetSteps getPetSteps;

    @Steps
    PutPetSteps putPetSteps;

    @Before
    public void createPrereq() {
        mypet.setId(133);
        mypet.setName("Animalut");
        mypet.setStatus("available");

    }

    @Title("This is a test that will create a new pet, will perform a get method to retrieve it and a put method to update it")
    @Test
    public void createPet() {
        Response createPetR = postPetSteps.createNewPet(mypet);
        Pet createdPet = createPetR.as(Pet.class);
        getPetSteps.getPetWithId(createdPet.getId());

    }

}
