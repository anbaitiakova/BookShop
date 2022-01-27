package com.serveeer.repos;

import com.serveeer.domain.Age;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgeRepo extends JpaRepository<Age, Long> {
@Query("select a from Age a where a.age_number=?1")
    Age findAgeByAge_number(int name);

}
