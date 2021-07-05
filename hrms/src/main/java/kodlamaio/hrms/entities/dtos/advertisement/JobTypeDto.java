package kodlamaio.hrms.entities.dtos.advertisement;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobTypeDto {
	@NotNull(message = "Çalışma Türü Boş Bırakılamaz")
	private String type;
}
