package com.serveeer.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "promo_code")
@Data
public class PromoCode {
    @Id
    @Column(name = "promo_code_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promo_code_id;

    @Column(name = "code")
    private String code;

    @Column(name = "discount")
    private Integer discount;
}
