package kodlamaio.hrms.api.controllers.advertisement;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.advertisement.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.advertisement.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.advertisement.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid JobAdvertisementDto jobAdvertisementDto) {
		return this.jobAdvertisementService.add(jobAdvertisementDto);
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("/findallbyisactive")
	public DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive) {
		return this.jobAdvertisementService.findAllByIsActive(isActive);
	}

	@GetMapping("/findallbyisactiveorderbycreateddatedesc")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive) {
		return this.jobAdvertisementService.findAllByIsActiveOrderByCreatedDateDesc(isActive);
	}

	@GetMapping("/getactiveadvertisementsbyemployerid")
	public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployerId(int employerId) {
		return this.jobAdvertisementService.getActiveAdvertisementsByEmployerId(employerId);
	}

	@GetMapping("getbyid")
	public DataResult<JobAdvertisement> getById(int id) {
		return this.jobAdvertisementService.getById(id);
	}

	@GetMapping("findallbyjobpositionid")
	public DataResult<List<JobAdvertisement>> findAllByJobPositionId(int id) {
		return this.jobAdvertisementService.findAllByJobPosition_Id(id);
	}

	@GetMapping("findallbycityid")
	public DataResult<List<JobAdvertisement>> findAllByCityId(int id) {
		return this.jobAdvertisementService.findAllByCity_Id(id);
	}

}
