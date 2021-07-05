package kodlamaio.hrms.dataAccess.abstracts.advertisement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.advertisement.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	List<JobAdvertisement> findAllByIsActive(boolean isActive);

	List<JobAdvertisement> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive);

	@Query("From JobAdvertisement where isActive=true and employer_id=:employerId")
	List<JobAdvertisement> getActiveAdvertisementsByEmployerId(int employerId);

	List<JobAdvertisement> findAllByJobPosition_Id(int id);

	List<JobAdvertisement> findAllByCity_Id(int id);
}
