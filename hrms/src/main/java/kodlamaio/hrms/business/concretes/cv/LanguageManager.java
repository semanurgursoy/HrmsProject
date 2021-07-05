package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.LanguageService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cv.LanguageDao;
import kodlamaio.hrms.entities.concretes.cv.Language;
import kodlamaio.hrms.entities.dtos.cv.LanguageDto;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;
	private ModelMapper modelMapper;

	@Autowired
	public LanguageManager(LanguageDao languageDao, ModelMapper modelMapper) {
		super();
		this.languageDao = languageDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(LanguageDto languageDto) {
		Language language = modelMapper.map(languageDto, Language.class);
		this.languageDao.save(language);
		return new SuccessResult(Messages.successfullyAdded);
	}

	@Override
	public DataResult<List<Language>> getByLanguageNameContains(String name) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getByLanguageNameContains(name), Messages.successfullyListed);
	}

	@Override
	public DataResult<List<Language>> getByLevel(int level) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getByLevel(level), Messages.successfullyListed);
	}

}
