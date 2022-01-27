package com.serveeer.repos;

import com.serveeer.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    @Query("select a from Author a where a.author_name=?1")
    Author findAuthorByAuthor_name(String name);
}
