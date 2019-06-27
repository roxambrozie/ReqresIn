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
import services.reqresin.pojo.node.User;
import services.reqresin.pojo.requests.UserJobRequest;
import services.reqresin.steps.PatchUserSteps;
import utils.methods.ReusableMethods;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "PATCH")
})
public class PatchUserPositiveTest {

    private String job;
    private int id;

    @Steps
    PatchUserSteps steps;

    @Steps
    private ReusableMethods reusableMethods;

    @Test
    @Title("This is a test that will patch a user based on id")
    @WithTags({
            @WithTag(type = "type", name = "Positive")
    })
    public void patchUser() {
        job = "Job1";
        id = 2;
        Response response = steps.patchUser(job, id);
        reusableMethods.validateResponseStatusCode(response, 200);
    }
}
