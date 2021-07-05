package kodlamaio.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	List<Language> getByLanguageNameContains(String name);

	List<Language> getByLevel(int level);
}
