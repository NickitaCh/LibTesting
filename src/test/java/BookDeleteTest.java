import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static book.BookClient.*;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookDeleteTest{
    int id;

    @Before
    public void setUp(){
        ValidatableResponse responseId = postTheBook(bookOne);
        id = responseId.extract().path("book.id");
    }

    @Test
    @DisplayName("Delete the book")
    public void testDeleteTheBook() {
        ValidatableResponse response = deleteOneBook(id);
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 200", SC_OK, statusCode);
        boolean isTrue = response.extract().path("result");
        assertTrue(isTrue);

    }

    @Test
    @DisplayName("Delete the book negative")
    public void testDeleteTheBookNegative() {
        ValidatableResponse response = deleteOneBook(0);
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 404", SC_NOT_FOUND, statusCode);
    }
}
