package kodlamaio.hrms.business.abstracts.cv;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Link;
import kodlamaio.hrms.entities.dtos.cv.LinkDto;

public interface LinkService {
	Result add(LinkDto linkDto);
}
