package kodlamaio.hrms.core.utilities.services.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<?> save(MultipartFile file);		
}
