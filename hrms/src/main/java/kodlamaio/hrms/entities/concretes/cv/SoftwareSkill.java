package kodlamaio.hrms.entities.concretes.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "software_skills")
public class SoftwareSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "software_skill_id")
	private int id;

	@Column(name = "technology_name")
	private String technologyName;

	@ManyToOne(targetEntity = JobSeekerCV.class)
	@JoinColumn(name = "job_seeker_cv_id", referencedColumnName = "job_seeker_cv_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private JobSeekerCV jobSeekerCV;

}
