package com.serveeer.repos;

import com.serveeer.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {
    @Query("select g from Genre g where g.genre_name=?1")
    Genre findGenreByGenre_name(String name);

}
