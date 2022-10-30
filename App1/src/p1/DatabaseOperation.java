package p1;
import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class DatabaseOperation {
	
	public static void main(String[] args) {
		
		Session hibernate = HibernateConnection.getHibernateLink();
		
		
		//Kid k1 = new Kid("Keerthi","female",11,LocalDate.of(2020, 11, 5).toString());
	
		Parents p = new Parents("virat","anushka",8979100541L);
	
		Parents g = new Parents("sami","gangavva",9214450278L);
		
	
		
		Vaccination v1 = new Vaccination("v1",LocalDate.of(2020, 6, 17).toString(),"v1",LocalDate.of(2019, 12, 20).toString(),"avg",1500);
		Vaccination v2 = new Vaccination("v2",LocalDate.of(2020, 11, 5).toString(),"v2",LocalDate.of(2020, 8, 9).toString(),"Good",900);
		Vaccination v3 = new Vaccination("v31",LocalDate.of(2021, 1, 20).toString(),"v31",LocalDate.of(2021, 3, 17).toString(),"bad",1250);
		
		List<Vaccination> AllVaccinationCertificates = Arrays.asList(v1,v2,v3);

		Kid k1 = new Kid("cutie","Female",15,LocalDate.of(2017, 10, 17).toString());
		Hospital h1=new Hospital("cmc","r2312ERT");
		Doctors d=new Doctors("rajendhra", "women specilist",7214450450L);
		List<Doctors>DoctorDetails=Arrays.asList(d);
		k1.setId(2);
		k1.setParent(p);
		k1.setGrandParent(g);
		k1.setVaccinationCard(AllVaccinationCertificates);
		h1.setDoctor(DoctorDetails);
		k1.setHospital(h1);
		
		insertKid(hibernate, k1);
	
		//doUpdate(hibernate, 2);
	
	}
	

	public static void doUpdate(Session hibernate, int id) {

		Transaction t1 = hibernate.beginTransaction();

		Kid kid = (Kid) hibernate.get(Kid.class, id);
		System.out.println(kid);

		System.out.println("------------ calling some setter methods-------------------------");

		kid.setName("Sudheer");
		kid.setGender("Male");
		

//		insertSudent(hibernate, k1);

		t1.commit();
		hibernate.close();

	}
		public static void insertKid(Session hibernate, Kid k) {

			Transaction t1 = hibernate.beginTransaction();

			hibernate.save(k); 
			

			t1.commit();
			hibernate.close();
			

			System.out.println(" 5. Database commit & hibernate closed ...");
		}
		
		
	}

