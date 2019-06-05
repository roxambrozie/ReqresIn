package regres.post.user;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.steps.PostUserSteps;
import utils.reusable.specifications.ReusableSpecifications;

@Concurrent(threads = "2x")
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata\\userinfo.csv")
@WithTags({
        @WithTag(type = "type", name = "POST")
})
public class PostNewUserDataDrivenTest {

    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Steps
    PostUserSteps steps;

    @Title("This is a data driven test that will create multiple new users")
    @Test
    public void createMultipleUsers() {
        steps.createUser(name, job).statusCode(201)
                .spec(ReusableSpecifications.getGenericResponseSpec());
    }

}
