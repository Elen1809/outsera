package com.outsera.core.utils;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredClient {

    public static Response get(String endpoint, Map<String, String> headers) {
        return given()
                .headers(headers)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response post(String endpoint, Map<String, String> headers, Object body) {
        return given()
                .headers(headers)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response put(String endpoint, Map<String, String> headers, Object body) {
        return given()
                .headers(headers)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response delete(String endpoint, Map<String, String> headers) {
        return given()
                .headers(headers)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}
