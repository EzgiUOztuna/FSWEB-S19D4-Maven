package com.workintech.s19d1.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "actor", schema = "fsweb")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @ManyToMany(mappedBy = "actors") // Movie tarafında oluşturduğumuz ilişkiye referans veriyoruz.
    private List<Movie> movies;

}
