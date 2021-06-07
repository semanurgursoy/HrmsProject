package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;

@RestController
@RequestMapping("/api/jobseekercvs")
public class JobSeekerCVsController {
	
	private JobSeekerCVService jobSeekerCVService;

	@Autowired
	public JobSeekerCVsController(JobSeekerCVService jobSeekerCVService) {
		super();
		this.jobSeekerCVService = jobSeekerCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerCV cv) {
		return this.jobSeekerCVService.add(cv);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerCV>> getAll(){
	    return this.jobSeekerCVService.getAll();
	}
	
	@GetMapping("/getAllSortedWorkExperience")
	public DataResult<List<JobSeekerCV>> getAllSortedWork(){
	    return this.jobSeekerCVService.getAllSortedEducation();
	}
	
	@GetMapping("/getAllSortedSchoolExperience")
	public DataResult<List<JobSeekerCV>> getAllSortedSchool(){
	    return this.jobSeekerCVService.getAllSortedExperience();
	}
	
}
