package com.serveeer.repos;

import com.serveeer.domain.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepo extends JpaRepository<PromoCode, Long> {
    PromoCode findPromoCodeByCode(String code);
}
