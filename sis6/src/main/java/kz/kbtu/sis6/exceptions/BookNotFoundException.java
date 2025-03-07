package kz.kbtu.sis6.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("Book not found");
    }

    public BookNotFoundException(Long id) {
        super("Book with ID " + id + " not found");
    }
}
