package com.serveeer.repos;

import com.serveeer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.username=?1")
    Customer findByUsername(String username);

    Customer findCustomerByEmail(String email);
}
