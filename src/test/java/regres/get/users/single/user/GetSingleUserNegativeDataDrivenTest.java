package regres.get.users.single.user;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.steps.GetUserSteps;
import utils.methods.ReusableMethods;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@WithTags({
        @WithTag(type = "type", name = "GET")
})
public class GetSingleUserNegativeDataDrivenTest {

    @TestData
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {100},
                {19029},
                {100000001}
        });
    }

    private final int id;

    public GetSingleUserNegativeDataDrivenTest(int id) {
        this.id = id;
    }

    @Steps
    private GetUserSteps steps;
    private ReusableMethods methods = new ReusableMethods();

    @Test
    @WithTags({
            @WithTag(type = "type", name = "Negative")
    })
    @Title("GET a single user from the list - negative test with data")
    public void getSingleUserNegative() {
        Response response = steps.getSingleUserFromListWithId(id);
        methods.validateResponseStatusCode(response, 404);
    }
}
