package com.project.travelAgency.repository;

import com.project.travelAgency.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepo extends JpaRepository<City, Long> {

    List<City> findCitiesByCountry_Name (String name);

    @Query("Select c from City c WHERE c.name like CONCAT(:firstLetter,'%')")
    List<City> myOwnQuery(@Param("firstLetter") String letter);
}
