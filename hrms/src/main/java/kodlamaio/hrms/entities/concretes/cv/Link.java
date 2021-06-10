package kodlamaio.hrms.entities.concretes.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="links")
public class Link {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="link_id")
	private int id;
	
	@Column(name="github_adress")
	private String githubAdress;
	
	@Column(name="linkedin_adress")
	private String linkedinAdress;
	

	@OneToOne(targetEntity = JobSeekerCV.class)
	@JoinColumn(name="job_seeker_cv_id",referencedColumnName="job_seeker_cv_id")
	@JsonProperty(access=Access.WRITE_ONLY)
	private JobSeekerCV jobSeekerCV;

} 
