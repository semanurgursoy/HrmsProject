package kodlamaio.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.cv.Education;

public interface EducationDao extends JpaRepository<Education,Integer> {
	
	List<Education> findAllByJobSeekerCV_IdOrderByGraduatedYearDesc(int cvId);
	
	@Query(value = "SELECT e.job_seeker_cv_id,e.school_id, e.school_name, e.school_department, e.begin_year, e.graduated_year, e.is_graduated"
			+ " from educations e left join job_seekers_cv cv on e.job_seeker_cv_id = cv.job_seeker_cv_id"
			+ " where cv.user_id=:jobSeekerId Order By e.graduated_year DESC Nulls First", nativeQuery = true)
	List<Education> getByJobSeekerIdWithOrdered(int jobSeekerId);

	Education getById(int educationId);
}
