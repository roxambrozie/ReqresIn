package regres.user.flow;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.steps.DeleteUserSteps;
import services.reqresin.steps.GetUserSteps;
import services.reqresin.steps.PostUserSteps;
import services.reqresin.steps.PutUserSteps;
import utils.reusable.specifications.ReusableSpecifications;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "FLOW")
})
public class UserFlowTest {

    private String name;
    private String job;
    private int id;

    @Steps
    private PostUserSteps postUserSteps;

    @Steps
    private GetUserSteps getUserSteps;

    @Steps
    private PutUserSteps putUserSteps;

    @Steps
    private DeleteUserSteps deleteUserSteps;

    @Title("This test will get a user and update it")
    @Test
    public void userEveCreateUpdateDeleteFlow() {
        name = "Eve";
        job = "QA";
        id = 4;
        postUserSteps.createUser(name, job).statusCode(201)
                .spec(ReusableSpecifications.getGenericResponseSpec());
        Response response = getUserSteps.getUserList(2);
        getUserSteps.checkUserWithFirstNamePresent(response, name);
        putUserSteps.updateUser(name, job, id).statusCode(200);
        deleteUserSteps.deleteUserFromListWithId(id);
    }

}

