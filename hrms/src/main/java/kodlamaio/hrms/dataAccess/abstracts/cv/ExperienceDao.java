package kodlamaio.hrms.dataAccess.abstracts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Experience;

public interface ExperienceDao extends JpaRepository<Experience,Integer> {

}
