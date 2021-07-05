package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Language;
import kodlamaio.hrms.entities.dtos.cv.LanguageDto;

public interface LanguageService {
	Result add(LanguageDto languageDto);

	DataResult<List<Language>> getByLanguageNameContains(String name);

	DataResult<List<Language>> getByLevel(int level);
}
