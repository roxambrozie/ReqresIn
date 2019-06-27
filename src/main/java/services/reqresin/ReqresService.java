package services.reqresin;

import utils.constants.TestConstants;

public class ReqresService {

    public String baseUri;
    public static final String GET_USERS_URI = "/api/users";
    public static final String GET_RESOURCES_URI = "/api/unknown";
    public static final String POST_USER_URI = "/api/users";

    public ReqresService() {
        this.baseUri = TestConstants.SECURE_PROTOCOL + "://" + TestConstants.REQRESIN_URI;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }
}
