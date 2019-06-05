package regres.get.resources.all.resources;

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
        @WithTag(type = "type", name = "GET"),
        @WithTag(type = "type", name = "Positive")
})
public class GetAllResourcesPositiveTest {
    ReusableMethods methods = new ReusableMethods();

    private String name;
    private String colorCode;
    private int year;
    private String pantoneValue;
    private int id;

    @Steps
    private GetResourceSteps steps;

    @Test
    @WithTags({
            @WithTag(type = "type", name = "Positive")
    })
    @Title("GET a list of resources on the Reqres app")
    public void getResourceList() {
        Response response = steps.getResourceList();
        methods.validateResponseStatusCode(response, 200);
    }

    @Test
    @Title("Check a resource  exists in the list by name")
    public void isResourceWithNameInList() {
        name = "true red";
        Response response = steps.getResourceList();
        steps.checkResourceWithNameExists(response, name);
    }

    @Test
    @Title("Check a resource  exists in the list by name")
    public void isResourceWithNameInList1() {
        name = "fuchsia rose";
        Response response = steps.getResourceList();
        steps.checkResourceWithNameExists(response, name);
    }

    @Test
    @Title("Check a resource  exists in the list by color code")
    public void isResourceWithColorInList() {
        colorCode = "#98B2D1";
        Response response = steps.getResourceList();
        steps.checkResourceWithColorExists(response, colorCode);
    }

    @Test
    @Title("Check a resource  exists in the list by year")
    public void isResourceWithYearInList() {
        year = 2002;
        Response response = steps.getResourceList();
        steps.checkResourceWithYearExists(response, year);
    }

    @Test
    @Title("Check a resource  exists in the list by pantone value")
    public void isResourceWithPantoneValueInList() {
        pantoneValue = "19-1664";
        Response response = steps.getResourceList();
        steps.checkResourceWithPantoneValueExists(response, pantoneValue);
    }

    @Test
    @Title("Check a resource  exists in the list by id")
    public void isResourceWithIdInList() {
        id = 3;
        Response response = steps.getResourceList();
        steps.checkResourceWithIdExists(response, id);
    }
}
