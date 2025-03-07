package kz.kbtu.sis4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("firstName")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @JsonProperty("lastName")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @JsonProperty("dateOfBirth")
    @Column(name = "date_of_birth", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
}
