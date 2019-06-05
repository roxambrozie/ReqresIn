package regres.get.users.all.users;

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
        @WithTag(type = "type", name = "GET"),
        @WithTag(type = "type", name = "Positive")
})
public class GetAllUsersPositiveTest {

    @Steps
    private GetUserSteps steps;

    ReusableMethods methods = new ReusableMethods();

    @Test
    @Title("GET a list of users on the Reqres app")
    public void getUserList() {
        Response response = steps.getUserList(1);
        methods.validateResponseStatusCode(response, 200);
    }

    @Test
    @Title("Check a user  exists in the list by first name")
    public void isUserWithFirstNameInList() {
        Response response = steps.getUserList(1);
        steps.checkUserWithFirstNamePresent(response, "George");
    }

    @Test
    @Title("Check a user exists in the list by last name")
    public void isUserWithLastNameInList() {
        Response response = steps.getUserList(1);
        steps.checkUserWithLastNamePresent(response, "Bluth");
    }

    @Test
    @Title("Check a user exists in the list by first name and last name")
    public void isUserWithFirstNameAndLastName() {
        Response response = steps.getUserList(1);
        steps.checkUserWithNameAndLastNameExists(response, "Emma", "Wong");
    }

    @Test
    @Title("Check a user exists in the list by email address")
    public void isUserWithEmailAddress() {
        Response response = steps.getUserList(2);
        steps.checkUserWithEmailAddressPresent(response, "tracey.ramos@reqres.in");
    }

    @Test
    @Title("Check a user exists in the list by avatar")
    public void isUserWithAvatar() {
        Response response = steps.getUserList(1);
        steps.checkUserWithAvatarPresent(response, "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
    }

    @Test
    @Title("Check all the information about a user is correctly present")
    public void userWithAllInfo() {
        Response response = steps.getUserList(1);
        steps.checkUserWithAllInfoExists(response, 3, "emma.wong@reqres.in", "Emma", "Wong", "https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");
    }

    @Test
    @Title("Check the number of users per page is correct")
    public void usersPerPage(){
        Response response =steps.getUserList(1);
        steps.usersPerPage(response, 3);
    }

    @Test
    @Title("Check the page number")
    public void checkPageNumber(){
        Response response = steps.getUserList(1);
        steps.currentPageNumber(response, 1);
    }

    @Test
    @Title("Check the total number of users")
    public void totalNumberOfUsers(){
        Response response = steps.getUserList(3);
        steps.totalUsersNumber(response, 12);
    }

    @Test
    @Title("Check the total number of pages with users")
    public void totalNumberOfPages(){
        Response response = steps.getUserList(1);
        steps.totalNumberOfPages(response,4);
    }

}
