package kodlamaio.hrms.entities.dtos.advertisement;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobTimeDto {
	@NotNull(message = "Çalışma Zamanı Boş Bırakılamaz")
	private String type;
}
