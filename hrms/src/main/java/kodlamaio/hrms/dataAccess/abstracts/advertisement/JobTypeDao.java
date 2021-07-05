package kodlamaio.hrms.dataAccess.abstracts.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.advertisement.JobType;

public interface JobTypeDao extends JpaRepository<JobType,Integer> {

}
