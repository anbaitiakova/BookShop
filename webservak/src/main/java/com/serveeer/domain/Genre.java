package com.serveeer.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "genre")
@Data
public class Genre {
    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genre_id;

    //@NotBlank(message = "Please fill the genre")
    @Column(name = "genre_name")
    private String genre_name;

    public Genre(String genre_name) {
        this.genre_name = genre_name;
    }

    public Genre() {

    }
}
