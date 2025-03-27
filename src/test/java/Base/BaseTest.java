package Base;

import config.ConfigManager;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private static String baseUrl;


    @BeforeClass
    public void setup() {
        baseUrl = ConfigManager.getBaseUrl();
        RestAssured.baseURI = baseUrl;
    }
}