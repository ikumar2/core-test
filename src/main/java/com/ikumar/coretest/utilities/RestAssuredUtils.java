package com.ikumar.coretest.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.google.gson.Gson;

public class RestAssuredUtils {

    private static final Gson gson = new Gson();

    public static Response sendGetRequest(String endpoint) {
        RequestSpecification request = RestAssured.given();
        return request.get(endpoint);
    }

    public static Response sendPostRequest(String endpoint, Object body) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(gson.toJson(body));
        return request.post(endpoint);
    }

    public static <T> T parseResponse(Response response, Class<T> clazz) {
        return gson.fromJson(response.getBody().asString(), clazz);
    }

    // Add more utility methods as needed
}