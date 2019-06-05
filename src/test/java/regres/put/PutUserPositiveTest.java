package regres.put;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.steps.PutUserSteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "PUT")
})
public class PutUserPositiveTest {

    private String name;
    private String job;
    private int id;
    private int statusCode = 200;


    @Steps
    PutUserSteps steps;

    @Title("This is a test that will update a user based on id")
    @Test
    public void putUser() {
        name = "User1";
        job = "Job1";
        id = 1;
        steps.updateUser(name, job, id).statusCode(statusCode);
    }

}
