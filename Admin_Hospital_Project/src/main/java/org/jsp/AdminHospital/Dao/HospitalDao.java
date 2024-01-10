package org.jsp.AdminHospital.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.AdminHospital.Dto.Admin;
import org.jsp.AdminHospital.Dto.Hospital;

public class HospitalDao {
	private EntityManager manager = Persistence.createEntityManagerFactory("md").createEntityManager();

	public Hospital saveHospital(Hospital hospital, int admin_id) {
		Admin ad = manager.find(Admin.class, admin_id);
		if (ad != null) {
			ad.getHospitals().add(hospital);
			hospital.setAdmin(ad);
			EntityTransaction transaction = manager.getTransaction();
			manager.persist(hospital);
			transaction.begin();
			transaction.commit();
			return hospital;
		}
		return null;
	}

	public Hospital updateHospital(Hospital hospital) {
		Hospital dbHospital = manager.find(Hospital.class, hospital.getId());
		if (dbHospital != null) {
			dbHospital.setFounder(hospital.getFounder());
			dbHospital.setName(hospital.getName());
			dbHospital.setGst(hospital.getGst());
			dbHospital.setYear_of_enstablishe(hospital.getYear_of_enstablishe());
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return dbHospital;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Hospital> findHospitalByAdminId(int admin_id) {
		Query q = manager.createQuery("select a.hospitals from Admin a where a.id=?1");
		q.setParameter(1, admin_id);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Hospital> findHospitals(long phone, String password) {
		Query q = manager.createQuery("select a.hospitals from Admin a where a.phone=?1 and a.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Hospital> findHospitals(String email, String password) {
		Query q = manager.createQuery("select a.hospitals from Admin a where a.email=?1 and a.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return q.getResultList();
	}

}
