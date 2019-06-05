package utils.methods;

import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReusableMethods {

    public void validateResponseStatusCode(Response response, int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

}
