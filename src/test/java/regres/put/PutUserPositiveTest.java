package regres.put;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.pojo.requests.UserJobRequest;
import services.reqresin.steps.PutUserSteps;
import utils.methods.ReusableMethods;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "service", name = "Regres"),
        @WithTag(type = "type", name = "Regression")
})
public class PutUserPositiveTest {

    private UserJobRequest myUser = new UserJobRequest();
    private int id;

    @Steps
    ReusableMethods reusableMethods;

    @Steps
    PutUserSteps steps;

    @Before
    public void createPrereq(){
        myUser.setName("Emma");
        myUser.setJob("QA");
    }

    @Title("This is a test that will update a user based on id")
    @WithTag(type = "type", name = "Smoke")
    @Test
    public void putUser() {
        id = 1;
        Response response = steps.updateUser(myUser, id);
        reusableMethods.validateResponseStatusCode(response,200);
    }

}
