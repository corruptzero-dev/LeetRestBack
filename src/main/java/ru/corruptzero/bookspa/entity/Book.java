package ru.corruptzero.bookspa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "published", columnDefinition = "datetime default current_timestamp()", nullable = false)
    private Date sqlDate = new Date(System.currentTimeMillis());
}
