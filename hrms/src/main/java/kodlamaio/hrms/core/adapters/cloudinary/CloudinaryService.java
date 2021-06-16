package kodlamaio.hrms.core.adapters.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<?> save(MultipartFile file);		
	DataResult<Map> delete (String id) throws IOException;
}
