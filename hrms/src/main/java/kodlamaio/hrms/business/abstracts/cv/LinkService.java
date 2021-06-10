package kodlamaio.hrms.business.abstracts.cv;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Link;

public interface LinkService {
	Result add(Link link);
}
