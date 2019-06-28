package regres.user.flow;

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
import services.reqresin.steps.DeleteUserSteps;
import services.reqresin.steps.GetUserSteps;
import services.reqresin.steps.PostUserSteps;
import services.reqresin.steps.PutUserSteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "service", name = "Regres"),
        @WithTag(type = "type", name = "Regression")
})
public class UserFlowTest {

    private User myUser = new User();
    private UserJobRequest myUserJobUpdate = new UserJobRequest();

    @Steps
    private PostUserSteps postUserSteps;

    @Steps
    private GetUserSteps getUserSteps;

    @Steps
    private PutUserSteps putUserSteps;

    @Steps
    private DeleteUserSteps deleteUserSteps;

    @Before
    public void createPrereqUser() {
        myUser.setFirst_name("Emma");
        myUser.setJob("QA");
        myUser.setId(3);
        myUserJobUpdate.setName("Emma");
        myUserJobUpdate.setJob("QA Automation");
    }

    @Title("This test will create, get and update a user")
    @WithTag(type = "type", name = "E2E")
    @Test
    public void userCreateUpdateDeleteFlow() {
        postUserSteps.createUser(myUser);
        Response response = getUserSteps.getUserListByPageNo(1);
        getUserSteps.checkUserWithFirstNamePresent(response, myUser.getFirst_name());
        putUserSteps.updateUser(myUserJobUpdate, myUser.getId());
        deleteUserSteps.deleteUserFromListWithId(myUser.getId());
    }
}

