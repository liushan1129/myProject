package sample.data.jpa.service;

import java.io.Serializable;

import org.springframework.util.Assert;

public class CitySearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;
	private String filter;

	public CitySearchCriteria() {
	}

	public CitySearchCriteria(String filter) {
		Assert.notNull(filter, "filter must not be null");
		this.filter = filter;
	}

	public String getFilter() {
		return this.filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
}
