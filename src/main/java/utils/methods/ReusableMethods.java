package utils.methods;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReusableMethods {

    @Step("Then I check the status code of the response when I perform this action is {1}")
    public void validateResponseStatusCode(Response response, int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    public int generateRandomInt(int min, int max){
        Random randomId = new Random();
      return randomId.ints(min, (max+1)).findFirst().getAsInt();
    }

}
