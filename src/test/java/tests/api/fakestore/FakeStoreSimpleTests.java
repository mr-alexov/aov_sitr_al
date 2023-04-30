package tests.api.fakestore;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class FakeStoreSimpleTests {

    @Test
    void getProduct1() {

        given()
                .log().all()
                .when()
                .get("https://fakestoreapi.com/products/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("title", is("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"));

    }

    @Test
    void deleteProduct6() {

        given()
                .log().all()
                .when()
                .delete("https://fakestoreapi.com/products/6")
                .then()
                .statusCode(200)
                .body("id", is(6))
                .body("title", is("Solid Gold Petite Micropave "));

    }


}
