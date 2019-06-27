package services.reqresin.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import services.reqresin.ReqresService;
import services.reqresin.pojo.node.User;
import services.reqresin.pojo.responses.GetUsersResponse;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class GetUserSteps {

    private ReqresService reqresService = new ReqresService();
    private String GET_USERS_URL = reqresService.getBaseUri() + ReqresService.GET_USERS_URI;
    private String PAGE_NO_QUERY_PARAM = "page";

    @Step("When I retrieve the list of users")
    public Response getUserList(int pageNo) {
        Response response = SerenityRest.rest().given().log().all()
                .baseUri(GET_USERS_URL)
                .queryParam(PAGE_NO_QUERY_PARAM, pageNo)
                .when()
                .get();
        response.then().log().all();

        return response;
    }

    @Step("When I retrieve a single user from the list based on id")
    public Response getSingleUserFromListWithId(int id) {
        Response response = SerenityRest.rest().given().log().all()
                .baseUri(GET_USERS_URL)
                .pathParam("id", id)
                .when()
                .get("/{id}");
        response.then().log().all();

        return response;
    }

    @Step("Then I check the user with the first name {1} exists")
    public void checkUserWithFirstNamePresent(Response response, String firstName) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        List<User> userList = getUsersResponse.getData();

        List<User> result = userList.stream().filter(user -> user.getFirst_name().equals(firstName)).collect(Collectors.toList());
        result.forEach(System.out::println);
        assertThat(result, hasSize(1));
        //response.then().body("data[0].first_name", is(firstName));
    }

    @Step("Then I check the user with the last name {1} exists")
    public void checkUserWithLastNamePresent(Response response, String lastName) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        List<User> userList = getUsersResponse.getData();

        List<User> result = userList.stream().filter(user -> user.getLast_name().equals(lastName)).collect(Collectors.toList());
        result.forEach(System.out::println);
        assertThat(result, hasSize(1));
    }

    @Step("Then I check that the user with first name {1} and last name {2} exists")
    public void checkUserWithNameAndLastNameExists(Response response, String firstName, String lastName) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        List<User> userList = getUsersResponse.getData();

        List<User> result1 = userList.stream()
                .filter(user -> user.getFirst_name().equals(firstName))
                .filter(user -> user.getLast_name().equals(lastName))
                .collect(Collectors.toList());
        result1.forEach(System.out::println);
        assertThat(result1, hasSize(1));
    }

    @Step("Then I check that the user with id {1}, email {2}, first name {3}, last name {4} and avatar {5} exists")
    public void checkUserWithAllInfoExists(Response response, int id, String email, String firstName, String lastName, String avatar) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        List<User> userList = getUsersResponse.getData();

        List<User> result1 = userList.stream()
                .filter(user -> user.getId().equals(id))
                .filter(user -> user.getEmail().equals(email))
                .filter(user -> user.getFirst_name().equals(firstName))
                .filter(user -> user.getLast_name().equals(lastName))
                .filter(user -> user.getAvatar().equals(avatar))
                .collect(Collectors.toList());
        result1.forEach(System.out::println);
        assertThat(result1, hasSize(1));
    }

    @Step("Then I check the user with the email address {1} exists")
    public void checkUserWithEmailAddressPresent(Response response, String email) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        List<User> userList = getUsersResponse.getData();

        List<User> result = userList.stream().filter(user -> user.getEmail().equals(email)).collect(Collectors.toList());
        result.forEach(System.out::println);
        assertThat(result, hasSize(1));
    }

    @Step("Then I check the user with the avatar {1} exists")
    public void checkUserWithAvatarPresent(Response response, String avatar) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        List<User> userList = getUsersResponse.getData();

        List<User> result = userList.stream().filter(user -> user.getAvatar().equals(avatar)).collect(Collectors.toList());
        result.forEach(System.out::println);
        assertThat(result, hasSize(1));
    }

    @Step("Then I check the current page number is {1}")
    public void currentPageNumber(Response response, int currentPageNumber) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        int currentPageNo = getUsersResponse.getPage();
        System.out.println(currentPageNo);
        assertThat(currentPageNo, equalTo(currentPageNumber));
    }

    @Step("Then I check there are {1} users per page")
    public void usersPerPage(Response response, int noOfUsers) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        int usersPerPage = getUsersResponse.getPer_page();
        System.out.println(usersPerPage);
        assertThat(usersPerPage, equalTo(noOfUsers));
    }

    @Step("Then I check there are {1} total users")
    public void totalUsersNumber(Response response, int totalNumberOfUsers) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        int totalNoOfUsers = getUsersResponse.getTotal();
        System.out.println(totalNoOfUsers);
        assertThat(totalNoOfUsers, equalTo(totalNumberOfUsers));
    }

    @Step("Then I check if the total number of pages is {1}")
    public void totalNumberOfPages(Response response, int totalNumberOfPages) {
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        int totalNoOfPages = getUsersResponse.getTotal_pages();
        System.out.println(totalNoOfPages);
        assertThat(totalNoOfPages, equalTo(totalNumberOfPages));
    }
}
