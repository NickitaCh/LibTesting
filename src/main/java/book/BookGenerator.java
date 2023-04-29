package book;

public class BookGenerator {
    public static Book bookOne() {
        return new Book("NIck", true, "World web", 2001);
    }

    public static Book bookTwo() {
        return new Book("Cool book");
    }

    public static Book bookThree() {
        return new Book("Qeb", false, 454);
    }

    public static Book bookFour() {
        return new Book("Pes", false, "Web World", 1114);
    }
}
