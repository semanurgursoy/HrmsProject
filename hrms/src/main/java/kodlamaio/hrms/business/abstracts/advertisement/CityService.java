package kodlamaio.hrms.business.abstracts.advertisement;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.advertisement.City;

public interface CityService {
	DataResult <List<City>> getAll();
}
