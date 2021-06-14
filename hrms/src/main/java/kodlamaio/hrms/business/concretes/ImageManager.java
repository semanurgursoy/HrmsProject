package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.services.cloudinary.CloudinaryService;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ImageManager(ImageDao imageDao,CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result saveImage(MultipartFile file, int userId) {
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) 
				cloudinaryService.save(file).getData(); 
		String imageUrl= uploader.get("url");
		Image image = this.imageDao.findByUserId(userId);
		image.setImageUrl(imageUrl);
		this.imageDao.save(image);
		return new SuccessResult(Messages.successfullyAdded);
	}
	
	@Override
	public void imageTableSetter(User user) {
		Image image = new Image();
		image.setUser(user);
		imageDao.save(image);
	}
	
	

	
	
}
