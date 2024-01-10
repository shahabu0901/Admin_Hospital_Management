package org.jsp.AdminHospital.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String founder;
	@Column(nullable = false, unique = true)
	private String gst;
	@Column(nullable = false)
	private int year_of_enstablishe;
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFounder() {
		return founder;
	}

	public String getGst() {
		return gst;
	}

	public int getYear_of_enstablishe() {
		return year_of_enstablishe;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public void setYear_of_enstablishe(int year_of_enstablishe) {
		this.year_of_enstablishe = year_of_enstablishe;
	}

}
