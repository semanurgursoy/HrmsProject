package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerVerifyBySystemStaff;

public interface EmployerVerifyBySystemStaffDao extends JpaRepository<EmployerVerifyBySystemStaff, Integer> {
	Optional<EmployerVerifyBySystemStaff> findByEmployerUuid(UUID uuid);

	boolean existsByEmployerUuidAndIsVerifiedTrue(UUID uuid);
}
