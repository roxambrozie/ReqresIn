package regres.get.resources.single.resource;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.steps.GetResourceSteps;
import utils.methods.ReusableMethods;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type= "type", name = "GET")
})
public class GetSingleResourceNegativeTest {
    ReusableMethods methods = new ReusableMethods();

    @Steps
    private GetResourceSteps steps;

    @Test
    @WithTags({
            @WithTag(type= "type", name = "Negative")
    })
    @Title("GET a single resource from the list based on id - negative test")
    public void getSingleResourceFromList() {
        Response response = steps.getResourceFromListWithId(21);
        methods.validateResponseStatusCode(response, 404);
    }

}
