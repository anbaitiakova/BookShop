package com.serveeer.repos;

import com.serveeer.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

    @Query("select b from Book b where b.book_id=?1")
    Book findBookByBook_id(Long id);

    @Query("select b from Book b join Author a on b.author.author_id = a.author_id where a.author_name=?1")
    List<Book> findByAuthor(String author);

    @Query("select b from Book b join Genre a on b.genre.genre_id = a.genre_id where a.genre_name=?1")
    List<Book> findByGenre(String genre);
}
