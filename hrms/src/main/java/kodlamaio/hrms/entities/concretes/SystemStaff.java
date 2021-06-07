package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="system_staffs")
@PrimaryKeyJoinColumn(name = "user_id")
public class SystemStaff extends User {
	
	@Column(name="name")
	private String name;
	
	@Column(name = "surname")
    private String surname;
	
	public SystemStaff(String email, String password, String name,String surname) {
        super(email, password);
        this.name = name;
        this.surname = surname;
    }
	
}
