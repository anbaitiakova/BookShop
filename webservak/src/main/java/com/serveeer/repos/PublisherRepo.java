package com.serveeer.repos;

import com.serveeer.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    @Query("select p from Publisher p where p.publisher_name=?1")
    Publisher findPublisherByPublisher_name(String name);
}
