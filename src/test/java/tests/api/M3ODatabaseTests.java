package tests.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class M3ODatabaseTests {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @Tag("simple_sampler")
    @Tag("simple_api")
    void getTables() {

        ValidatableResponse response =
                given().contentType(ContentType.JSON)
                        .header("authorization", "Bearer NzQ5YmZkNDctZjllYy00NmNlLTg5ZGMtN2E3MjVkYWIwNmUz")
                        .log().all()
                        .when()
                        .get("https://api.m3o.com/v1/db/ListTables")
                        .then()
                        .log().all();

    }
}
