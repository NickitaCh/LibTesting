import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static book.BookClient.*;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.junit.Assert.assertEquals;

public class BookPostTest {
    @Test
    @DisplayName("Post correct book")
    public void testPostTheBook() {
        ValidatableResponse response = postTheBook(bookTwo);
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 201", SC_CREATED, statusCode);
    }

    @Test
    @DisplayName("Post the book negative")
    public void testPostTheBookNegative() {
        ValidatableResponse response = postTheBook(bookThree);
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 400", SC_BAD_REQUEST, statusCode);
    }
}