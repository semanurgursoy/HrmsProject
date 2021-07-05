package kodlamaio.hrms.business.abstracts.advertisement;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.advertisement.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.advertisement.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisementDto jobAdvertisementDto);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive);

	DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive);

	DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployerId(int employerId);

	DataResult<JobAdvertisement> getById(int id);

	DataResult<List<JobAdvertisement>> findAllByJobPosition_Id(int id);

	DataResult<List<JobAdvertisement>> findAllByCity_Id(int id);
}
