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
        @WithTag(type = "service", name = "Regres"),
        @WithTag(type = "type", name = "Regression")
})
public class GetSingleUserPositiveDataDrivenTest {

    @TestData
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1},
                {2},
                {3},
                {4},
                {10}
        });
    }

    private final int id;

    public GetSingleUserPositiveDataDrivenTest(int id) {
        this.id = id;
    }

    @Steps
    private GetUserSteps steps;
    private ReusableMethods methods = new ReusableMethods();

    @Test
    @Title("GET a single user from the list based on id - positive test with data")
    public void getSingleUserFromList() {
        Response response = steps.getSingleUserFromListWithId(id);
        methods.validateResponseStatusCode(response, 200);
    }


}
