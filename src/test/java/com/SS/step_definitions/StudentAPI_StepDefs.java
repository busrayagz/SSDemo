package com.SS.step_definitions;

import com.SS.utilities.ConfigurationReader;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class StudentAPI_StepDefs {

    @BeforeAll
    public static void init(){

        baseURI= ConfigurationReader.getProperty("baseURI");
    }
    Response response;
    int actualStatusCode;
    @Given("I logged SchoolStatus api as a {string}")
    public void i_logged_school_status_api_as_a(String teacher) {

    }
    @When("I send POST request {string} endpoint with following information")
    public void i_send_post_request_endpoint_with_following_information(String endpoint, Map<String,Object> studentInfo) {

        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(studentInfo)
                .when().post(endpoint).prettyPeek();

        actualStatusCode = response.getStatusCode();

        //extra

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("data.name"));


    }
    @Then("status code should be {int}")
    public void status_code_should_be(int expectedStatusCode) {

        Assert.assertEquals(expectedStatusCode,actualStatusCode);

    }


}
