package kodlamaio.hrms.business.concretes.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.LinkService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cv.LinkDao;
import kodlamaio.hrms.entities.concretes.cv.Link;

@Service
public class LinkManager implements LinkService {

	private LinkDao linkDao;
	
	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult(Messages.successfullyAdded);
	}
	
}
