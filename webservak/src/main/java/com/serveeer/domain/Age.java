package com.serveeer.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ages")
@Data
public class Age {
    @Id
    @Column(name = "age_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long age_id;

    @Column(name = "age_number")
    private int age_number;

    public Age(int age_number) {
        this.age_number = age_number;
    }

    public Age() {}
}
