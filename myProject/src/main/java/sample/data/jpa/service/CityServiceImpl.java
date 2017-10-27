package sample.data.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import sample.data.jpa.domain.City;
import sample.data.jpa.domain.HotelSummary;

import javax.xml.soap.SOAPPart;

@Component("cityService")
@Transactional
public class CityServiceImpl implements CityService {

	private final CityRepository cityRepository;

	private final HotelRepository hotelRepository;

	public CityServiceImpl(CityRepository cityRepository,
			HotelRepository hotelRepository) {
		this.cityRepository = cityRepository;
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Page<City> findCities(CitySearchCriteria criteria, Pageable pageable) {

		Assert.notNull(criteria, "Criteria must not be null");
		String filter = criteria.getFilter();

		if (!StringUtils.hasLength(filter)) {
			return this.cityRepository.findAll(null);
		}

		System.out.println("ABC");
		String country = "";
		String name = "";
		//只适合有两个查询条件的时候
		int splitPos = filter.lastIndexOf(",");

		if (splitPos >= 0) {
			country = filter.substring(splitPos + 1);
			name = filter.substring(0, splitPos);
		}

		return this.cityRepository
				.findByNameContainingAndCountryContainingAllIgnoringCase(name.trim(),
						country.trim(), pageable);
	}

	@Override
	public City getCity(String name, String country) {
		Assert.notNull(name, "Name must not be null");
		Assert.notNull(country, "Country must not be null");
		return this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country);
	}

	@Override
	public Page<HotelSummary> getHotels(City city, Pageable pageable) {
		Assert.notNull(city, "City must not be null");
		return this.hotelRepository.findByCity(city, pageable);
	}

	@Override
	public Page<City> findAll(Pageable pageable) {
		
		return this.cityRepository.findAll(pageable);
	}

}
