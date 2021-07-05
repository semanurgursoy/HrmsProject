package kodlamaio.hrms.dataAccess.abstracts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {

}
