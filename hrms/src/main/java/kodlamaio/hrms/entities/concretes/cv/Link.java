package kodlamaio.hrms.entities.concretes.cv;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_seeker_cv_id")
	@JsonIgnore
	private JobSeekerCV jobSeekerCV;

} 
