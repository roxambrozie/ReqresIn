package petshop.get;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.petshop.pojo.Pet;
import services.petshop.steps.CommonSteps;
import services.petshop.steps.GetPetSteps;
import services.petshop.steps.PostPetSteps;

@RunWith(SerenityRunner.class)
@WithTags({@WithTag(type = "type", name = "Verify Pet Parameters")})
public class PetVerifyParametersTest {

    private Pet myPet = new Pet();
    int id;
    String name;
    String status;

    @Steps
    CommonSteps commonSteps;

    @Steps
    PostPetSteps postPetSteps;

    @Steps
    GetPetSteps getPetSteps;

    @Before
    public void createPrereq() {
        id = 1;
        name = "doggie";
        status = "sold";
        myPet.setId(id);
        myPet.setName(name);
        myPet.setStatus(status);
        postPetSteps.createNewPet(myPet);
    }

    @Title("This test will verify if the pet name is as expected")
    @Test
    public void verifyPetName() {
        commonSteps.verifyPetName(getPetSteps.getPetUsingId(id), name);
    }

    @Title("This test will verify if the pet status is as expected")
    @Test
    public void verifyPetStatus(){
        commonSteps.verifyPetStatus(getPetSteps.getPetUsingId(id), status);
    }
}
