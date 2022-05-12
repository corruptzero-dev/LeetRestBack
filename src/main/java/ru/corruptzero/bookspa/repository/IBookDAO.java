package ru.corruptzero.bookspa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.corruptzero.bookspa.entity.Book;

public interface IBookDAO extends JpaRepository<Book, Long> {
    Book findBookById(Long id);
    Boolean existsBookByTitleAndAuthor(String title, String author);
    Book findBookByIsbn(String isbn);
}
