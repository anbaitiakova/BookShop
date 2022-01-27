package com.serveeer.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ways_of_delivery")
@Data
public class WaysOfDelivery {
    @Id
    @Column(name = "way_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long way_id;

    @Column(name = "ways")
    private String ways;

    @Column(name = "delivery_price")
    private Integer delivery_price;
}
