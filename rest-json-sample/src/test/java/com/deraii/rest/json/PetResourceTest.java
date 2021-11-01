package com.deraii.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PetResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/pets")
          .then()
             .statusCode(200)
             .body("$.size()", is(3),
                     "[0].name", is("ムギ"),
                     "[0].description", is("犬：トイプードル"),
                     "[1].name", is("サクラ"),
                     "[1].description", is("犬：チワワ"),
                     "[2].name", is("ハッピー"),
                     "[2].description", is("犬：ミックス犬")
                     );
    }

}