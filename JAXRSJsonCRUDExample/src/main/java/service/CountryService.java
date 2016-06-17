package service;

import model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountryService {

	static HashMap<Integer,Country> countryIdMap = getCountryIdMap();

	public CountryService() {
		super();

		if (countryIdMap == null) {
			countryIdMap = new HashMap<Integer, Country>();
			countryIdMap.put(1, new Country(1, "India", 10000));
			countryIdMap.put(2, new Country(2, "China", 20000));
			countryIdMap.put(3, new Country(3, "Nepal", 30000));
			countryIdMap.put(4, new Country(4, "Bhutan", 40000));
		}
	}

	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>(countryIdMap.values());
		return countries;
	}

	public Country getCountry(int id) {
		Country country = countryIdMap.get(id);
		return country;
	}

	public Country addCountry(Country country) {
		country.setId(countryIdMap.size() + 1);
		countryIdMap.put(country.getId(), country);
		return country;
	}

	public Country updateCountry(Country country) {
		if (country.getId() <= 0)
			return null;
		countryIdMap.put(country.getId(), country);
		return country;
	}

	public void deleteCountry(int id) {
		countryIdMap.remove(id);
	}

	public static HashMap<Integer, Country> getCountryIdMap() {
		return countryIdMap;
	}

}
