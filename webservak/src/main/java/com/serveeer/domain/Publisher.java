package com.serveeer.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
@Data
public class Publisher {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisher_id;

    //@NotBlank(message = "Please fill the publisher")
    @Column(name = "publisher_name")
    private String publisher_name;

    public Publisher(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public Publisher() {

    }
}
