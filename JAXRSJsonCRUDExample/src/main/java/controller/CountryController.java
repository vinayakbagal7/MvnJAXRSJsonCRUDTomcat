package controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Country;
import service.CountryService;

@Path("/countries")
public class CountryController {

	CountryService countryService = new CountryService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries() {
		return countryService.getAllCountries();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/country")
	public Country getCountryById(@QueryParam("id") int id) {
		return countryService.getCountry(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country) {
		return countryService.addCountry(country);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country) {
		return countryService.updateCountry(country);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteCountry(@PathParam("id") int id) {
		countryService.deleteCountry(id);
	}
}
