package regres.patch;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.steps.PatchUserSteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "PATCH")
})
public class PatchUserPositiveTest {

    private String job;
    private int id;
    private int statusCode = 200;


    @Steps
    PatchUserSteps steps;

    @Test
    @Title("This is a test that will patch a user based on id")
    @WithTags({
            @WithTag(type = "type", name = "Positive")
    })
    public void patchUser() {
        job = "Job1";
        id = 2;
        steps.patchUser(job, id).statusCode(statusCode);
    }

}
