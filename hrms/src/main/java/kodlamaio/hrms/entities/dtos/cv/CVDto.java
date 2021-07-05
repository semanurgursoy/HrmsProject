package kodlamaio.hrms.entities.dtos.cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVDto {
	private int id;

	private String coverLetter;

	private int jobSeekerId;

}
