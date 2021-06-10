package kodlamaio.hrms.business.abstracts.cv;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Language;

public interface LanguageService {
	Result add(Language language);
}
