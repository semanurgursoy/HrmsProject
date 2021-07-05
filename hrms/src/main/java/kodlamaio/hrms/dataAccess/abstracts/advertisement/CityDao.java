package kodlamaio.hrms.dataAccess.abstracts.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.advertisement.City;

public interface CityDao extends JpaRepository<City,Integer> {

}
