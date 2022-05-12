package ru.corruptzero.bookspa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.corruptzero.bookspa.service.BookService;

@Controller
public class MainController {
    @Autowired
    BookService service;

    @GetMapping("/book/{isbn}")
    public ModelAndView getBookPage(@PathVariable String isbn){
        return new ModelAndView("bookpage").addObject(service.getBookByIsbn(isbn));
    }
}
