package kz.kbtu.sis6.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotBlank()
    @Size(min = 0, max = 30)
    private String title;

    @Column(name = "author")
    @NotBlank()
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "genre")
    private String genre;

    @Column(name = "isbn")
    @JsonProperty("isbn")
    private String isbnNumber;
}
