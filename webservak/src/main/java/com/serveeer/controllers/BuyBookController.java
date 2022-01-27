package com.serveeer.controllers;

import com.serveeer.domain.*;
import com.serveeer.repos.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Date;

@Controller
public class BuyBookController {
    private final WaysRepo waysRepo;
    private final BookRepo bookRepo;
    private final CityRepo cityRepo;
    private final CustomerRepo customerRepo;
    private final BuyRepo buyRepo;
    private final BuyBookRepo buyBookRepo;
    private final PromoRepo promoRepo;

    public BuyBookController(WaysRepo waysRepo, BookRepo bookRepo,
                             CityRepo cityRepo, CustomerRepo customerRepo,
                             BuyRepo buyRepo, BuyBookRepo buyBookRepo, PromoRepo promoRepo) {
        this.waysRepo = waysRepo;
        this.bookRepo = bookRepo;
        this.cityRepo = cityRepo;
        this.customerRepo = customerRepo;
        this.buyRepo = buyRepo;
        this.buyBookRepo = buyBookRepo;
        this.promoRepo = promoRepo;
    }

    @GetMapping("/buybook/{name}/{book_id}")
    public String orderInfo(
            Model model,
            @RequestParam(required = false) Book book
    ) {
        Iterable<City> city = cityRepo.findAll();
        model.addAttribute("city", city);
        Iterable<WaysOfDelivery> waysOfDeliveries = waysRepo.findAll();
        model.addAttribute("waysOfDeliveries", waysOfDeliveries);
        return "buyBook";
    }

    @PostMapping("/buybook/{name}/{book_id}")
    public String buy(@RequestParam("citySelect") String citySelect,
                      @RequestParam(required=false, name="order_comments") String order_comments,
                      @RequestParam(required=false, name="promo_code") String promo_code,
                      @RequestParam("waysSelect") String waysSelect,
                      @ModelAttribute("book_id") long id,
                      @ModelAttribute("name") String name,
                      Model model
    ) throws IOException {
        Book book = bookRepo.findBookByBook_id(id);
        City city = cityRepo.findCityByCity_name(citySelect);
        WaysOfDelivery way = waysRepo.findWaysOfDeliveriesByWays(waysSelect);
        Customer customer = customerRepo.findByUsername(name);
        PromoCode promoCode = promoRepo.findPromoCodeByCode(promo_code);
        Buy buy =  new Buy(new Date(),true, promoCode, customer, way, order_comments, city);
        buyRepo.save(buy);

        int sum = book.getPrice() + way.getDelivery_price();
        if(promoCode != null)
        {
            double discount = (100 - promoCode.getDiscount()) / 100.0;
            sum *= discount;
            model.addAttribute("ifDiscount", promo_code);
        }
        BuyBook buyBook = new BuyBook(new Date(), sum, book, buy);
        buyBookRepo.save(buyBook);
        model.addAttribute("orderNumber", buyBook.getBuy_book_id());
        model.addAttribute("sum", sum);
        Integer amount = book.getAmount();
        book.setAmount(amount - 1);
        bookRepo.save(book);
        return "afterBuy";
    }
}
