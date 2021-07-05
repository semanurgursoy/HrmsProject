package kodlamaio.hrms.dataAccess.abstracts.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.advertisement.JobPosition;

public interface PositionDao extends JpaRepository<JobPosition,Integer>{
	
}
