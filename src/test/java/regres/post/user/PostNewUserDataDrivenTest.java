package regres.post.user;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import services.reqresin.pojo.node.User;
import services.reqresin.steps.PostUserSteps;
import utils.methods.ReusableMethods;

@Concurrent(threads = "2x")
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata\\userinfo.csv")
@WithTags({
        @WithTag(type = "service", name = "Regres"),
        @WithTag(type = "type", name = "Regression")
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

    private User myUser = new User();

    @Steps
    private PostUserSteps postUserSteps;

    @Steps
    private ReusableMethods reusableMethodsSteps;

    @Before
    public void createPrereqUser(){
        myUser.setName(name);
        myUser.setJob(job);
    }

    @Title("This is a data driven test that will create multiple new users")
    @Test
    public void createMultipleUsers() {
       Response createMultipleUsersResponse = postUserSteps.createUser(myUser);
       reusableMethodsSteps.validateResponseStatusCode(createMultipleUsersResponse, 201);
    }
}
