package ru.corruptzero.bookspa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.corruptzero.bookspa.entity.Book;
import ru.corruptzero.bookspa.messages.Message;
import ru.corruptzero.bookspa.repository.IBookDAO;

@Service
public class BookService {

    @Autowired
    private IBookDAO repository;
    private Boolean existsByTitleAndAuthor(Book book){
        return repository.existsBookByTitleAndAuthor(book.getTitle(), book.getAuthor());
    }

    public Book getBookByIsbn(String isbn){
        return repository.findBookByIsbn(isbn);
    }
    public String addBook(Book book){
        if (existsByTitleAndAuthor(book)){
            return Message.ALREADY_EXISTS;
        }
        repository.save(book);
        return Message.SUCCESSFULLY_ADDED;
    }

    public Page<Book> getBooks(Pageable pageable){return repository.findAll(pageable);}
    public Book getBookById(Long id){return repository.findBookById(id);}

    public String updateBook(Book newBook) {
        Book oldBook = repository.getById(newBook.getId());
        if(repository.existsById(newBook.getId())){
            oldBook.setAuthor(newBook.getAuthor());
            oldBook.setDescription(newBook.getDescription());
            oldBook.setGenre(newBook.getGenre());
            oldBook.setImage(newBook.getImage());
            oldBook.setIsbn(newBook.getIsbn());
            oldBook.setTitle(newBook.getTitle());
            repository.save(oldBook);
            return Message.SUCCESSFULLY_CHANGED;
        }
        return Message.NOT_EXISTS;
    }

    public String deleteBook(Book book){
        repository.delete(book);
        return Message.SUCCESSFULLY_DELETED;
    }

}