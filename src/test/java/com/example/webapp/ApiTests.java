package com.example.webapp;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.awaitility.Awaitility.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {

    @Test
    public void testGetSuccess() {
        RestAssured.baseURI = "http://localhost:8080/api";
        given()
                .when().get("/health")
                .then()
                .statusCode(200)
                .body("status", equalTo("UP"));
    }

    @Test
    public void testPostFailure() {
        RestAssured.baseURI = "http://localhost:8080/api";
        given()
                .header("Content-Type", "application/json")
                .body("{ \"invalid\": \"data\" }")
                .when().post("/users")
                .then()
                .statusCode(400);
    }
}
