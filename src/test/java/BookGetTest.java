import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.LinkedHashMap;

import static book.BookClient.*;
import static book.BookClient.bookOne;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

public class BookGetTest {

    @Test
    @DisplayName("Get all books")
    public void testGetAllBooks() {
        ValidatableResponse response = getBooks();
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 200", SC_OK, statusCode);
    }

    @Test
    @DisplayName("Get one book")
    public void testGetTheBook() {
        ValidatableResponse responseId = postTheBook(bookOne);
        int id = responseId.extract().path("book.id");
        ValidatableResponse response = getOneBook(id);
        int rId = response.extract().path("book.id");
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 200", SC_OK, statusCode);
        assertEquals("Id совпадает", id, rId);
    }

    @Test
    @DisplayName("Get one book negative")
    public void testGetTheBookNegative() {
        ValidatableResponse response = getOneBook(0);
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 404", SC_NOT_FOUND, statusCode);
    }
}
