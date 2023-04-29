package book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String author;
    private boolean isElectronicBook;
    private String name;
    private int year;

    public Book(String name) {
        this.name = name;
    }

    public Book(String author, boolean isElectronicBook, int year) {
        this.author = author;
        this.isElectronicBook = isElectronicBook;
        this.year = year;
    }
}
