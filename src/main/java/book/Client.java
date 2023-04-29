package book;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Client {
    private static final String BASE_URL = "http://localhost:5000/api/books";

    public static RequestSpecification getBaseSpec() {
        return given().baseUri(BASE_URL).header("Content-type", "application/json");
    }
}
