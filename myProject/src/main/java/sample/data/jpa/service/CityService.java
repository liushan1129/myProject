package sample.data.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sample.data.jpa.domain.City;
import sample.data.jpa.domain.HotelSummary;

public interface CityService {
	Page<City> findAll(Pageable pageable);
	
	Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);

	City getCity(String name, String country);

	Page<HotelSummary> getHotels(City city, Pageable pageable);
	
}
