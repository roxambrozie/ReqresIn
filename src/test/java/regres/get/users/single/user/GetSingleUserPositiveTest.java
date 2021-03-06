package regres.get.users.single.user;


import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.steps.GetUserSteps;
import utils.methods.ReusableMethods;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "service", name = "Regres"),
        @WithTag(type = "type", name = "Regression")
})
public class GetSingleUserPositiveTest {

    @Steps
    private GetUserSteps steps;

    private ReusableMethods methods = new ReusableMethods();

    @Test
    @WithTag(type = "type", name = "Smoke")
    @Title("GET a single user from the list based on id")
    public void getSingleUserFromList() {
        Response response = steps.getSingleUserFromListWithId(1);
        methods.validateResponseStatusCode(response, 200);
    }


}
