package com.serveeer.repos;

import com.serveeer.domain.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepo extends JpaRepository<Buy, Long> {
}
