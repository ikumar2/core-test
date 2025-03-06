package com.ikumar.coretest.stepdefinitions;

import com.ikumar.coretest.models.SampleModel;
import com.ikumar.coretest.utilities.RestAssuredUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public class SampleSteps {

    private Response response;

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        response = RestAssuredUtils.sendGetRequest("https://jsonplaceholder.typicode.com" + endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(expectedStatusCode);
    }

    @Then("the response should contain a todo item with title {string}")
    public void theResponseShouldContainATodoItemWithTitle(String expectedTitle) {
        SampleModel todoItem = RestAssuredUtils.parseResponse(response, SampleModel.class);
        Assertions.assertThat(todoItem.getTitle()).isEqualTo(expectedTitle);
    }
}