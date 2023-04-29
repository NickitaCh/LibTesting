import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static book.BookClient.*;
import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.assertEquals;

public class BookPutTest {
    int id;

    @Before
    public void setUp(){
        ValidatableResponse responseId = postTheBook(bookOne);
        id = responseId.extract().path("book.id");
    }

    @Test
    @DisplayName("Put the book")
    public void testPutTheBook() {
        ValidatableResponse response = putOneBook(id);
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 200", SC_OK, statusCode);
    }

    @Test
    @DisplayName("Put the book negative")
    public void testPutTheBookNegative() {
        ValidatableResponse response = putOneBookNegative(id);
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 400", SC_BAD_REQUEST, statusCode);
    }

    @Test
    @DisplayName("Put the book negative")
    public void testPutTheBookWrongId() {
        ValidatableResponse response = putOneBook(0);
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 404", SC_NOT_FOUND, statusCode);
    }
}