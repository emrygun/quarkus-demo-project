package com.emrygun.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when()
                .header("authorization", "testAuth")
                .get("/hello?order=TestOrder")
          .then()
             .statusCode(200)
             .body(is(String.format("URI: %s - Order: %s - Authorization: %s", "/hello", "TestOrder", "testAuth")));
    }

}