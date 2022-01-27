package com.serveeer.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "buy_book")
@Data
public class BuyBook {
    @Id
    @Column(name = "buy_book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buy_book_id;

    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "amount")
    private Integer orderPrice;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book orderBook;

    @OneToOne
    @JoinColumn(name = "buy_id")
    private Buy buy;

    public BuyBook(Date order_date, Integer orderPrice, Book orderBook, Buy buy) {
        this.order_date = order_date;
        this.orderPrice = orderPrice;
        this.orderBook = orderBook;
        this.buy = buy;
    }

    public BuyBook() {}
}
