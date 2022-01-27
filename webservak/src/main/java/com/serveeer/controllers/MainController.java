package com.serveeer.controllers;

import com.serveeer.domain.*;
import com.serveeer.repos.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class MainController {

    private final BookRepo bookRepo;

    private final AuthorRepo authorRepo;

    private final GenreRepo genreRepo;

    private final PublisherRepo publisherRepo;

    private final AgeRepo ageRepo;

    public MainController(BookRepo bookRepo, AuthorRepo authorRepo, GenreRepo genreRepo, PublisherRepo publisherRepo, AgeRepo ageRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.genreRepo = genreRepo;
        this.publisherRepo = publisherRepo;
        this.ageRepo = ageRepo;
    }


    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, @RequestParam(required = false, defaultValue = "") String filterAuthor, Model model) {
        Iterable<Book> books = bookRepo.findAll();
        books = bookRepo.findAll();
        model.addAttribute("books", books);
        model.addAttribute("filter", filter);
        model.addAttribute("filterAuthor", filterAuthor);
        return "main";
    }
    /**/
    @PostMapping("/main")
    public String add(
            @RequestParam String title,
            @RequestParam String isbn,
            @RequestParam Integer year_publ,
            @RequestParam Integer price,
            @RequestParam String author,
            @RequestParam String genre,
            @RequestParam String publisher,
            @RequestParam Integer age,
            @RequestParam Integer amount,
            Model model
    ) throws IOException {

        Publisher publisherFromDB = publisherRepo.findPublisherByPublisher_name(publisher);
        Genre genreFromDB = genreRepo.findGenreByGenre_name(genre);
        Age ageFromDB = ageRepo.findAgeByAge_number(age);
        Author authorFromDB = authorRepo.findAuthorByAuthor_name(author);

        if (publisherFromDB == null)
        {
            publisherFromDB = new Publisher(publisher);
            publisherRepo.save(publisherFromDB);
        }
        if (authorFromDB == null)
        {
            authorFromDB = new Author(author);
            authorRepo.save(authorFromDB);
        }
        if(ageFromDB == null)
        {
            ageFromDB = new Age(age);
            ageRepo.save(ageFromDB);
        }
        if(genreFromDB == null)
        {
            genreFromDB = new Genre(genre);
            genreRepo.save(genreFromDB);
        }

        Book book = new Book(title, isbn, year_publ,
                price, amount, authorFromDB,
                genreFromDB, publisherFromDB, ageFromDB);
        bookRepo.save(book);



        Iterable<Book> books = bookRepo.findAll();
        model.addAttribute("books", books);
        return "main";
    }

    @GetMapping("/edit/{book_id}")
    public String bookEdit(
            Model model,
            @RequestParam(required = false) Book book
    ) {
        /*Iterable<Book> books = bookRepo.findBookByBook_id(curr.getBook_id());
        model.addAttribute("books", books);*/

        return "bookEdit";
    }

    @PostMapping("/edit/{book_id}")
    public String updateAmount(
            @ModelAttribute("book_id") long id,
            @RequestParam("amount") Integer amount
    ) throws IOException {
        Book book = bookRepo.findBookByBook_id(id);
            if (!StringUtils.isEmpty(amount)) {
                book.setAmount(amount);
            }

            bookRepo.save(book);

        return "redirect:/main";
    }
}