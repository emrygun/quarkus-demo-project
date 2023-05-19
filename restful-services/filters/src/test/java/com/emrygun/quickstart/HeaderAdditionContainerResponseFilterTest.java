package com.emrygun.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@QuarkusTest
class HeaderAdditionContainerResponseFilterTest {

    @Test
    public void headerAdditionFilterShouldAddHeaderOnOkRequest() {
        given()
                .when()
                    .get("/filter-test")
                .then()
                    .statusCode(200)
                    .header("R-Filter", is("Header added by Jax-RS ContainerResponseFilter."));
    }

}