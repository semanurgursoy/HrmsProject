package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
		public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
			return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/findallbyisactive")
	public DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive){
		return this.jobAdvertisementService.findAllByIsActive(isActive);
	}
	
	@GetMapping("/findallbyisactiveorderbycreateddatedesc")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive){
		return this.jobAdvertisementService.findAllByIsActiveOrderByCreatedDateDesc(isActive);
	}
	
	@GetMapping("/getactiveadvertisementsbyemployerid")
	public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployerId(int employerId){
		return this.jobAdvertisementService.getActiveAdvertisementsByEmployerId(employerId);
	}
	
	
	
}
