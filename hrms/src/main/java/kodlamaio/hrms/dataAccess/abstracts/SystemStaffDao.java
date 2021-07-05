package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemStaff;

public interface SystemStaffDao extends JpaRepository<SystemStaff, Integer> {
	Optional<SystemStaff> findByUuid(UUID uuid);
}
