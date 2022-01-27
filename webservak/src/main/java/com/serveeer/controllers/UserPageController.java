package com.serveeer.controllers;

import com.serveeer.domain.Book;
import com.serveeer.repos.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserPageController {
    private final BookRepo bookRepo;

    public UserPageController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/")
    public String greeting(@RequestParam(required = false, defaultValue = "") String filter,
                           @RequestParam(required = false, defaultValue = "") String filterAuthor,
                           @RequestParam(required = false, defaultValue = "") String filterGenre,
                           Model model) {
        Iterable<Book> books = bookRepo.findAll();
        if(filter != null && !filter.isEmpty()) {
            books = bookRepo.findByTitle(filter);
        } else if(filterAuthor != null && !filterAuthor.isEmpty()) {
            books = bookRepo.findByAuthor(filterAuthor);
        } else if(filterGenre != null && !filterGenre.isEmpty()) {
            books = bookRepo.findByGenre(filterGenre);
        }else
            books = bookRepo.findAll();
        model.addAttribute("books", books);
        model.addAttribute("filter", filter);
        model.addAttribute("filterAuthor", filterAuthor);
        return "greeting";
    }

    @GetMapping("/userPage")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
                       @RequestParam(required = false, defaultValue = "") String filterAuthor,
                       @RequestParam(required = false, defaultValue = "") String filterGenre,
                       Model model) {
        Iterable<Book> books = bookRepo.findAll();
        if(filter != null && !filter.isEmpty()) {
            books = bookRepo.findByTitle(filter);
        } else if(filterAuthor != null && !filterAuthor.isEmpty()) {
            books = bookRepo.findByAuthor(filterAuthor);
        } else if(filterGenre != null && !filterGenre.isEmpty()) {
            books = bookRepo.findByGenre(filterGenre);
        } else
            books = bookRepo.findAll();
        model.addAttribute("books", books);
        model.addAttribute("filter", filter);
        model.addAttribute("filterAuthor", filterAuthor);
        return "userPage";
    }
}
