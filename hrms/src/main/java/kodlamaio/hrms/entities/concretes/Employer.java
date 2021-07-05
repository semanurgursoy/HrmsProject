package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.concrete.User;
import kodlamaio.hrms.entities.concretes.advertisement.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "employers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;

	public Employer(String email, String password, String companyName, String website, String telephone) {
		super(email, password);
		this.companyName = companyName;
		this.website = website;
		this.telephone = telephone;
	}

}
