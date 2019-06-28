package services.reqresin;

import utils.constants.TestConstants;

public class ReqresService {

    public String baseUri;
    public static final String USERS_URI = "/api/users";
    public static final String RESOURCES_URI = "/api/unknown";

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
