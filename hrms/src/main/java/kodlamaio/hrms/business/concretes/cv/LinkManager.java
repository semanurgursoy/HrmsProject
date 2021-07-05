package kodlamaio.hrms.business.concretes.cv;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.LinkService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cv.LinkDao;
import kodlamaio.hrms.entities.concretes.cv.Link;
import kodlamaio.hrms.entities.dtos.cv.LinkDto;

@Service
public class LinkManager implements LinkService {

	private LinkDao linkDao;
	private ModelMapper modelMapper;

	@Autowired
	public LinkManager(LinkDao linkDao, ModelMapper modelMapper) {
		super();
		this.linkDao = linkDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(LinkDto linkDto) {
		Link link = modelMapper.map(linkDto, Link.class);
		this.linkDao.save(link);
		return new SuccessResult(Messages.successfullyAdded);
	}

}
