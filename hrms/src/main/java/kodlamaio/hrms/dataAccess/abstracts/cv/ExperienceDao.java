package kodlamaio.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.cv.Experience;

public interface ExperienceDao extends JpaRepository<Experience,Integer> {
	
	List<Experience> findAllByJobSeekerCV_IdOrderByEndDateDesc(int cvId);
	
	@Query(value = "SELECT e.experience_id,e.job_seeker_cv_id,e.workplace, e.position, e.still_work, e.begin_date, e.end_date"
			+ " from experiences e left join job_seekers_cv cv on e.job_seeker_cv_id = cv.job_seeker_cv_id"
			+ " where cv.user_id=:jobSeekerId Order By e.end_date DESC Nulls First", nativeQuery = true)
	List<Experience> getByExperienceIdWithOrdered(int jobSeekerId);

	Experience getById(int experienceId);
}
