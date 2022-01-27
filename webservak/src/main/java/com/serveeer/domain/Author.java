package com.serveeer.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data
public class Author{

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long author_id;

    @Column(name = "author_name")
    private String author_name;

    public Author() {
    }

    public Author(String author_name) {
        this.author_name = author_name;
    }
}


