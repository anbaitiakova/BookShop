package com.serveeer.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "buy")
@Data
public class Buy {

    @Id
    @Column(name = "buy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buy_book_id;

    @Column(name = "date_of_buying")
    private Date date_of_buying;

    @Column(name = "paid_or_not")
    private boolean paid_or_not;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "way_id")
    private WaysOfDelivery waysOfDelivery;

    @Column(name = "order_comments")
    private String order_comments;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "promo_code_id")
    private PromoCode promoCode;

    public Buy(Date date_of_buying, boolean paid_or_not, PromoCode promoCode, Customer customer, WaysOfDelivery waysOfDelivery, String order_comments, City city) {
        this.date_of_buying = date_of_buying;
        this.paid_or_not = paid_or_not;
        this.promoCode = promoCode;
        this.customer = customer;
        this.waysOfDelivery = waysOfDelivery;
        this.order_comments = order_comments;
        this.city = city;
    }

    public Buy() { }
}
