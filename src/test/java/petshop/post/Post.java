package petshop.post;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.petshop.pojo.Pet;
import services.petshop.steps.PostPetSteps;
import utils.methods.ReusableMethods;

@RunWith(SerenityRunner.class)
@WithTag(type = "type", name = "test")
public class Post {

    Pet myPet = new Pet();

    @Steps
    PostPetSteps postPetSteps;

    @Steps
    ReusableMethods reusableMethods;

    @Before
    public void createPrereq() {
        myPet.setId(2);
        myPet.setName("Animalut");
        myPet.setStatus("available");
    }

    @Test
    public void createPet(){
        Response response = postPetSteps.createNewPet(myPet);
        reusableMethods.validateResponseStatusCode(response, 200);
    }
}
