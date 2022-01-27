package com.serveeer.repos;

import com.serveeer.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    @Query("select c from City c where c.city_name=?1")
    City findCityByCity_name(String city);
}
