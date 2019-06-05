package regres.delete;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.steps.DeleteUserSteps;
import utils.methods.ReusableMethods;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "DELETE")
})
public class DeleteSingleUserTest {

    @Steps
    private DeleteUserSteps steps;

    ReusableMethods methods = new ReusableMethods();

    @Test
    @WithTags({
            @WithTag(type = "type", name = "Positive")
    })
    @Title("DELETE a single user from the list based on id")
    public void deleteSingleUserFromListPositiveTest() {
        Response response = steps.deleteUserFromListWithId(1);
        methods.validateResponseStatusCode(response, 204);
    }

}
