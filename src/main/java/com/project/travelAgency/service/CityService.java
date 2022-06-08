package com.project.travelAgency.service;

import com.project.travelAgency.entities.City;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.CityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepo cityRepo;

    public City save(City city) {
        return cityRepo.save(city);
    }

    public List<City> findAll() {
        return cityRepo.findAll();
    }

    public City findById(Long id) {
        return cityRepo.findById(id)
                .orElseThrow(()-> new NoIdException("City with given id not found"));
    }
    public List <City> findCitiesByCountries_Name (String country){
        return cityRepo.findCitiesByCountry_Name(country);
    }
    public List<City> findByP(String firstletter){
        return cityRepo.myOwnQuery(firstletter);
    }


    public boolean deleteById(Long id) {
        cityRepo.delete(findById(id));
        return true;
    }
}
