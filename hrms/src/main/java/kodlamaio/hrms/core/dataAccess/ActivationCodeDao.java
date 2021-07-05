package kodlamaio.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.concrete.ActivationCode;

import java.util.Optional;
import java.util.UUID;

public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer> {
	Optional<ActivationCode> findByUserUuid(UUID uuid);

	Optional<ActivationCode> findByCode(String code);
	
	ActivationCode getByUserUuid(UUID uuid);
}
