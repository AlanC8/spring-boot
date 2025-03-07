package kz.kbtu.sis6.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kz.kbtu.sis6.exceptions.BookNotFoundException;
import kz.kbtu.sis6.model.Book;
import kz.kbtu.sis6.repository.BookRepository;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content)})
    @GetMapping("/{id}")
    public Book findById(@Parameter(description = "id of book to be searched")
                         @PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException());
    }

    @Operation(summary = "Create a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input provided")})
    @PostMapping("/")
    public Book createBook(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Book to create", required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class),
                    examples = @ExampleObject(value = "{ \"title\": \"New Book\", \"author\": \"Author Name\" }")))
                           @RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping("/")
    public Iterable<Book> findBooks() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(
            @PathVariable("id") final String id, @RequestBody final Book book) {
        return book;
    }

    @GetMapping("/filter")
    public Page<Book> filterBooks(@ParameterObject Pageable pageable) {
        return repository.findAll(pageable);
    }
}