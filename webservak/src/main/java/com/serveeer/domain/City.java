package com.serveeer.domain;
import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "city")
@Data
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long city_id;

    @Column(name = "city_name")
    private String city_name;
}
