package kodlamaio.hrms.api.controllers.cv;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.LinkService;
import kodlamaio.hrms.entities.concretes.cv.Link;

@RestController
@RequestMapping("/api/links")
public class LinksController {
	
	private LinkService linkService;

	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Link link) {
		return ResponseEntity.ok(this.linkService.add(link));
	}
	
}
