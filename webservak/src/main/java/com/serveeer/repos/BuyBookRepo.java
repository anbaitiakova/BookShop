package com.serveeer.repos;

import com.serveeer.domain.BuyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyBookRepo extends JpaRepository<BuyBook, Long> {
}
