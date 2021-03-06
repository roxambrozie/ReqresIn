package regres.patch;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.pojo.requests.UserJobRequest;
import services.reqresin.steps.PatchUserSteps;
import utils.methods.ReusableMethods;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "service", name = "Regres"),
        @WithTag(type = "type", name = "Regression")
})
public class PatchUserPositiveTest {

    private UserJobRequest myUser = new UserJobRequest();
    private int id;

    @Steps
    PatchUserSteps steps;

    @Steps
    private ReusableMethods reusableMethods;

    @Before
    public void createPrereq() {
        myUser.setName("Emma");
        myUser.setJob("QA Automation");
    }

    @Test
    @Title("This is a test that will patch a user based on id")
    @WithTag(type = "type", name = "Smoke")
    public void patchUser() {
        id = 1;
        Response response = steps.patchUser(myUser, id);
        reusableMethods.validateResponseStatusCode(response, 200);
    }
}
