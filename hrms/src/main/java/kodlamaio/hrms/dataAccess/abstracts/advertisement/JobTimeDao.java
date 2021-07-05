package kodlamaio.hrms.dataAccess.abstracts.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.advertisement.JobTime;

public interface JobTimeDao extends JpaRepository<JobTime,Integer> {

}
