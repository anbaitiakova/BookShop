package com.serveeer.repos;

import com.serveeer.domain.WaysOfDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaysRepo extends JpaRepository<WaysOfDelivery, Long> {
    WaysOfDelivery findWaysOfDeliveriesByWays(String ways);
}
