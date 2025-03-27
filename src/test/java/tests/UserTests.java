package tests;

import Base.BaseTest;
import config.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoggerUtil;

import static io.restassured.RestAssured.given;

public class UserTests extends BaseTest {
    private int userId;


   @Test(priority = 1 , description = "Create User")
    public void createUser() {

        String requestBody = "{ \"name\": \"" + ConfigManager.getUserName() + "\", " +
                "\"job\": \"" + ConfigManager.getUserJob() + "\", " +
                "\"age\": \"" + ConfigManager.getUserAge() + "\" }";

            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post("/api/users")
                    .then()
                    .statusCode(201)
                    .extract().response();

            userId = response.jsonPath().getInt("id"); // Store user ID
            Assert.assertNotNull(userId);
            System.out.println("Create User Response: " + response.asString());
            System.out.println("The userID is : " + userId);
    }

    @Test(priority = 2, dependsOnMethods = "createUser",description = "Retrieve User")
    public void retrieveUser() {
        try {
            Response response = given()
                    .when()
                    .get("/api/users/" + userId)
                    .then()
                    .extract().response();

            if (response.statusCode() == 404) {
                System.out.println("reqres.in does not save created users: The GET request will likely return 404.");
            } else {
                Assert.assertEquals(response.statusCode(), 200);
                String retrievedName = response.jsonPath().getString("data.name");
                Assert.assertEquals(retrievedName, ConfigManager.getUserName(), "User name mismatch!");
            }
        }catch (Exception e) {
            LoggerUtil.logError("Error retrieving user: " + e.getMessage());
            throw e;
    }
        }
    @Test(priority = 3, dependsOnMethods = "createUser" , description = "Update User")
    public void updateUser() {
        String updatedRequestBody = "{ \"name\": \"" + ConfigManager.getUserName() + "\", " +
                "\"job\": \"" + ConfigManager.getUpdatedJob() + "\"}";

            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(updatedRequestBody)
                    .when()
                    .put("/api/users/" + userId)
                    .then()
                    .statusCode(200)
                    .extract().response();

            String updatedJob = response.jsonPath().getString("job");
            System.out.println("Updated Job: " + updatedJob);
            Assert.assertEquals(response.jsonPath().getString("job"), "Quality Control");
    }
}
