package book;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class BookClient extends Client {
    private static final String NO_ID_API = "";
    private static final String API_WITH_ID = "/";

    public static final Book bookOne = BookGenerator.bookOne();
    public static final Book bookTwo = BookGenerator.bookTwo();
    public static final Book bookThree = BookGenerator.bookThree();
    public static final Book bookFour = BookGenerator.bookFour();

    @Step("Get all books")
    public static ValidatableResponse getBooks() {
        return given()
                .spec(getBaseSpec())
                .get(NO_ID_API)
                .then();
    }

    @Step("Post the book")
    public static ValidatableResponse postTheBook(Book book) {
        return given()
                .spec(getBaseSpec())
                .body(book)
                .post(NO_ID_API)
                .then();
    }

    @Step("Get the book")
    public static ValidatableResponse getOneBook(int id) {
        return given()
                .spec(getBaseSpec())
                .get(API_WITH_ID + id)
                .then();
    }

    @Step("Put the book")
    public static ValidatableResponse putOneBook(int id) {
        return given()
                .spec(getBaseSpec())
                .body(bookFour)
                .put(API_WITH_ID + id)
                .then();
    }

    @Step("Put the book negative")
    public static ValidatableResponse putOneBookNegative(int id) {
        return given()
                .spec(getBaseSpec())
                .body(bookTwo)
                .put(API_WITH_ID + id)
                .then();
    }

    @Step("Delete the book")
    public static ValidatableResponse deleteOneBook(int id) {
        return given()
                .spec(getBaseSpec())
                .delete(API_WITH_ID + id)
                .then();
    }
}
