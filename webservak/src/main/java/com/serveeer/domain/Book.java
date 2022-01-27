package com.serveeer.domain;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "book", schema = "public")
@Data
public class Book {
    public Book(){}

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long book_id;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "year_publ")
    private Integer year_publ;

    @Column(name = "price")
    private Integer price;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "age_id")
    private Age age;

    public Book(String title, String isbn, Integer year_publ,
                Integer price, Integer amount, Author author,
                Genre genre, Publisher publisher, Age age) {
        this.title = title;
        this.isbn = isbn;
        this.year_publ = year_publ;
        this.price = price;
        this.amount = amount;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.age = age;
    }
}
