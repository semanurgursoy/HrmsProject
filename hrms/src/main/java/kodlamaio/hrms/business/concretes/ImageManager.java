package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.adapters.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.entities.concrete.User;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	private UserDao userDao;
	
	@Autowired
	public ImageManager(ImageDao imageDao,CloudinaryService cloudinaryService,UserDao userDao) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
		this.userDao = userDao;
	}

	@Override
	public Result saveImage(MultipartFile file, int userId) {
		System.out.println(file);
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) 
				cloudinaryService.save(file).getData(); 
		String imageUrl= uploader.get("url");
		System.out.println(imageUrl);
		Image image = new Image();
		image.setUser(this.userDao.findById(userId));
		image.setImageUrl(imageUrl);
		this.imageDao.save(image);
		return new SuccessResult(Messages.successfullyAdded);
	}
	
	
	
	

	
	
}
