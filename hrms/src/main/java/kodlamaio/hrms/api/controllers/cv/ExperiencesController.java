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

import kodlamaio.hrms.business.abstracts.cv.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Experience;
import kodlamaio.hrms.entities.dtos.cv.ExperienceDto;

@RestController
@RequestMapping("/api/controllers")
@CrossOrigin
public class ExperiencesController {

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody ExperienceDto experienceDto) {
		return this.experienceService.add(experienceDto);
	}

	@GetMapping("/orderByEndDate")
	DataResult<List<Experience>> orderByEndDate(int cvId) {
		return experienceService.orderByEndDate(cvId);
	}

	@GetMapping("/getByExperienceIdWithOrdered")
	DataResult<List<Experience>> getByExperienceIdWithOrdered(int jobSeekerId) {
		return experienceService.getByExperienceIdWithOrdered(jobSeekerId);
	}

	@PostMapping("/getById")
	public DataResult<Experience> getById(int experienceId) {
		return experienceService.getById(experienceId);
	}

	@GetMapping("/getByWorkplaceContains")
	DataResult<List<Experience>> getByWorkplaceContains(String name) {
		return experienceService.getByWorkplaceContains(name);
	}

	@GetMapping("/getByJobPositionId")
	DataResult<List<Experience>> getByJobPositionId(int id) {
		return experienceService.getByJobPositionId(id);
	}

}
