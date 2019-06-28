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
        @WithTag(type = "service", name = "Regres"),
        @WithTag(type = "type", name = "Regression")
})
public class GetSingleResourcePositiveTest {
   private ReusableMethods methods = new ReusableMethods();

    @Steps
    private GetResourceSteps steps;

    @Test
    @WithTag(type = "type", name = "Smoke")
    @Title("GET a single resource from the list based on id")
    public void getSingleResourceFromList() {
        Response response = steps.getResourceFromListWithId(1);
        methods.validateResponseStatusCode(response, 200);
    }

}
