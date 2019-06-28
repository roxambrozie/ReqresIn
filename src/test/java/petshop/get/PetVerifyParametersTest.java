package petshop.get;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.petshop.pojo.Pet;
import services.petshop.steps.CommonSteps;
import services.petshop.steps.DeletePetSteps;
import services.petshop.steps.GetPetSteps;
import services.petshop.steps.PostPetSteps;

@RunWith(SerenityRunner.class)
@WithTags({@WithTag(type = "service", name = "Pet"),
        @WithTag(type = "type", name = "Regression")})
public class PetVerifyParametersTest {

    private Pet myPet = new Pet();

    @Steps
    CommonSteps commonSteps;

    @Steps
    GetPetSteps getPetSteps;

    @Steps
    DeletePetSteps deletePetSteps;

    @Steps
    PostPetSteps postPetSteps;

    @Before
    public void createPrereq() {
        myPet = commonSteps.createValidPetObject("Dog", "sold");
        postPetSteps.createNewPet(myPet);
    }

    @Title("This test will verify if the pet name is as expected")
    @Test
    public void verifyPetName() {
        commonSteps.verifyPetName(getPetSteps.getPetUsingId(myPet.getId()), myPet.getName());
    }

    @Title("This test will verify if the pet status is as expected")
    @WithTag(type = "type", name = "smoke")
    @Test
    public void verifyPetStatus() {
        commonSteps.verifyPetStatus(getPetSteps.getPetUsingId(myPet.getId()), myPet.getStatus());
    }

    @After
    public void afterMethod() {
        deletePetSteps.deletePetUsingId(myPet.getId());
    }
}
