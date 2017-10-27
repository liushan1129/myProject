package sample.data.jpa.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.City;
import sample.data.jpa.service.CitySearchCriteria;
import sample.data.jpa.service.CityService;

@Controller
public class CityController {

	@Autowired
	private CityService cityService;

	// 全部city信息分页查询
	@GetMapping("/findAll")
	@ResponseBody
	@Transactional(readOnly = true)
	public Page<City> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize) {
		Pageable pageable = new PageRequest(page, pageSize);
		Page<City> cityPage = cityService.findAll(pageable);
		return cityPage;
	}

	// city信息根据查询条件分页查询
	@PostMapping("/findCriteria")
	@ResponseBody
	@Transactional(readOnly = true)
	public Page<City> findAllByCriteria(@RequestParam(value = "filter", defaultValue = "") String filter,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize) {
		Sort s = new Sort(Sort.Direction.ASC, "id"); 
		Pageable pageable = new PageRequest(page, pageSize, s);
		CitySearchCriteria criteria = new CitySearchCriteria();
		criteria.setFilter(filter);
		Page<City> cityPage = cityService.findCities(criteria, pageable);
		return cityPage;
	}
}
