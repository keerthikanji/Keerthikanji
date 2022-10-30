package p1;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Kid {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;

	@Column(name = "Kid_Name")
	private String name;
	private String gender;
	private int weight;
	private String dob;
	
	@Embedded
	private Parents parent;
	
	@Embedded
	@AttributeOverrides({
		
		@AttributeOverride(name ="fatherName", column = @Column(name = "grandFather")),
		@AttributeOverride(name ="motherName", column = @Column(name = "grandMother")),
		@AttributeOverride(name ="phoneNumber", column = @Column(name = "gPhoneNumber")),
		
	})
	
	private Parents grandParent;
	
	 @ElementCollection
		@CollectionTable(name = "VaccinationCertificates")
		 private List<Vaccination> vaccinationCard;
	 
	 @OneToOne(targetEntity = Hospital.class,cascade = CascadeType.ALL)
	 private Hospital hospital;

	
	
	

	public Kid(String name, String gender, int weight, String dob) {
		super();
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.dob = dob;
		
	}



}

