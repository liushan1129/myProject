package sample.data.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class City implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="city_generator", sequenceName="city_sequence", initialValue = 23)
	@GeneratedValue(generator = "city_generator")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private String map;

	public City() {
	}

	public City(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getMap() {
		return map;
	}

	@Override
	public String toString() {
		return getName() + "," + getState() + "," + getCountry();
	}
	
}
