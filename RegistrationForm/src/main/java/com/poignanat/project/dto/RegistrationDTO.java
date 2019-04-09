package com.poignanat.project.dto;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Registration")
public class RegistrationDTO {

	public RegistrationDTO() {
		System.out.println("cretated:"+this.getClass().getSimpleName());
	
	}
	@Id
	@GenericGenerator(name="any",strategy = "increment")
	@GeneratedValue(generator = "any")
	@Column(name="r_id")
	private int id;
	@Column(name="r_firstname")
	private String firstname;
	@Column(name="r_email")
	private String email;
	@Column(name="r_gender")
	private String gender;
	@Column(name="r_upload")
	private byte[] uploadfiles;
	public String getFirstname() {
		return firstname;
	}
	public String setFirstname(String firstname) {
		return this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public String setEmail(String email) {
		return this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public String setGender(String gender) {
		return this.gender = gender;
	}
	@Override
	public String toString() {
		return "RegistrationDTO [firstname=" + firstname + ", email=" + email + ", gender=" + gender + ", uploadfiles="
				+ Arrays.toString(uploadfiles) + "]";
	}
	public byte[] getUploadfiles() {
		return uploadfiles;
	}
	public void setUploadfiles(byte[] uploadfiles) {
		this.uploadfiles = uploadfiles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
