package kodlamaio.hrms.api.controllers.cv;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.cv.Language;
import kodlamaio.hrms.entities.dtos.cv.LanguageDto;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody LanguageDto languageDto) {
		return ResponseEntity.ok(this.languageService.add(languageDto));
	}

	@GetMapping("/getByLanguageNameContains")
	DataResult<List<Language>> getByLanguageNameContains(String name) {
		return languageService.getByLanguageNameContains(name);
	}

	@GetMapping("/getByLevel")
	DataResult<List<Language>> getByLevel(int level) {
		return languageService.getByLevel(level);
	}

}
