package kodlamaio.hrms.dataAccess.abstracts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV,Integer> {

}
