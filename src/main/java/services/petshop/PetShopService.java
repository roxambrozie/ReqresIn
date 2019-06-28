package services.petshop;

import utils.constants.TestConstants;

public class PetShopService {

    public String baseUri;

    public static final String PET_URI = "/pet";

    public PetShopService() {
        this.baseUri = TestConstants.SECURE_PROTOCOL + "://" + TestConstants.PETSTORE_URI;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }
}
