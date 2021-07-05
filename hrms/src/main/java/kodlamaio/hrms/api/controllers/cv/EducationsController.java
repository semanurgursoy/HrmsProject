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

import kodlamaio.hrms.business.abstracts.cv.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.cv.Education;
import kodlamaio.hrms.entities.dtos.cv.EducationDto;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody EducationDto educationDto) {
		return ResponseEntity.ok(this.educationService.add(educationDto));
	}

	@GetMapping("/orderByGraduatedYear")
	DataResult<List<Education>> orderByGraduatedYear(int cvId) {
		return educationService.orderByGraduatedYear(cvId);
	}

	@GetMapping("/getByJobSeekerIdWithOrdered")
	DataResult<List<Education>> getByJobSeekerIdWithOrdered(int jobSeekerId) {
		return educationService.getByJobSeekerIdWithOrdered(jobSeekerId);
	}

	@PostMapping("/getById")
	public DataResult<Education> getById(int educationId) {
		return educationService.getById(educationId);
	}

	@GetMapping("/getBySchoolNameContains")
	DataResult<List<Education>> getBySchoolNameContains(String schoolName) {
		return educationService.getBySchoolNameContains(schoolName);
	}

	@GetMapping("/getByDepartmentContains")
	DataResult<List<Education>> getByDepartmentContains(String department) {
		return educationService.getByDepartmentContains(department);
	}

}
