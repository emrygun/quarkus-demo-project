package com.emrygun.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ApplicationRoutesTest {

    @Test
    public void okRouteShouldReturn() {
        given()
            .when()
                .get("/ok")
            .then()
                .statusCode(200)
                .body(is("Ok from RouteContext HttpServletResponse"));
    }

    @Test
    public void declarativeOkRouteShoudReturn() {
        given()
            .when()
                .get("/declarative-ok")
            .then()
                .statusCode(200)
                .body(is("Ok from RouteContext HttpServletResponse"));
    }


    @Test
    public void headerAdditionFilterShouldAddHeaderOnOkRequest() {
        given()
            .when()
                .get("/ok")
            .then()
                .statusCode(200)
                .header("V-Header", is("Header added by Vert.x filter."));
    }

}