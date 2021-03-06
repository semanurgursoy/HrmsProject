package kodlamaio.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.SoftwareSkill;

public interface SoftwareSkillDao extends JpaRepository<SoftwareSkill, Integer> {
	List<SoftwareSkill> getByTechnologyNameContains(String name);
}
