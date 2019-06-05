package services.reqresin;

import utils.constants.TestConstants;

public class ReqresService {

    public String baseUri;
    public static final String GET_LIST_OF_USERS = "/api/users";
    public static final String GET_SINGLE_USER= "/api/users/";
    public static final String GET_LIST_OF_RESOURCES = "/api/unknown";
    public static final String GET_SINGLE_RESOURCE = "/api/unknown/";
    public static final String POST_CREATE_USER = "/api/users";
    public static final String PUT_USER_UPDATE = "/api/users/";
    public static final String DELETE_USER = "/api/users/";
    public static final String POST_REGISTER ="/api/register";

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
