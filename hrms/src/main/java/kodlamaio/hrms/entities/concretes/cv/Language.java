package kodlamaio.hrms.entities.concretes.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id")
	private int id;
	
	@Column(name="language_name")
	private String languageName;
	
	@Min(1)
	@Max(5)
	@Column(name="language_level")
	private int level;
	
	@ManyToOne(targetEntity = JobSeekerCV.class)
	@JoinColumn(name="job_seeker_cv_id",referencedColumnName="job_seeker_cv_id")
	@JsonProperty(access=Access.WRITE_ONLY)
	private JobSeekerCV jobSeekerCV;
	
}
