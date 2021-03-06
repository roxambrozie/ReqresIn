package utils.constants;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import utils.property.PropertiesUtil;

import java.util.Properties;

public class TestConstants {

    private static Logger log = LoggerFactory.getLogger(TestConstants.class);

    //properties
    private static String propFilePath = PropertiesUtil.setConfigPath();
    public static final Properties properties = PropertiesUtil.loadProperties(propFilePath);

    //environment
    public static final String ENVIRONMENT = PropertiesUtil.getString(properties, "environment");

    public static final String REQRESIN_URI = PropertiesUtil.getString(properties, "regres.baseURI");
    public static final String PETSTORE_URI = PropertiesUtil.getString(properties, "petstore.baseURI");

    //generic
    public static final String PROTOCOL = PropertiesUtil.getString(properties, "protocol");
    public static final String SECURE_PROTOCOL = PropertiesUtil.getString(properties, "secureProtocol");
    public static final String PORT = PropertiesUtil.getString(properties, "port");



}
