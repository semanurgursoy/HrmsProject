package kodlamaio.hrms.entities.concretes.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="software_skills")
public class SoftwareSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="software_skill_id")
	private int id;
	
	@Column(name="technology_name")
	private String technologyName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="job_seeker_cv_id")
	@JsonIgnore
	private JobSeekerCV jobSeekerCV;
	
}
