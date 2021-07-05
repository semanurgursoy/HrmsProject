package kodlamaio.hrms.entities.dtos.advertisement;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionDto {
	@NotNull(message = "Pozisyon İsmi Boş Bırakılamaz")
	private String position;
}
