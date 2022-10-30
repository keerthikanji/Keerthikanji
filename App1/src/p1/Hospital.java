package p1;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
private int id;
	@Column(name="Hospital_name")
private String name;
private String registrationno;


@OneToOne(targetEntity =Kid.class)
@PrimaryKeyJoinColumn
private Kid kid;

@ElementCollection
@CollectionTable(name="DoctorDetails")
private List<Doctors> doctor;

public Hospital(String name, String registrationno) {
	super();
	this.name = name;
	this.registrationno = registrationno;
	
}


}
