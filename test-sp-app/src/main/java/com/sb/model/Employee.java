package com.sb.model;

import org.hibernate.query.sqm.FetchClauseType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	private int id;
	private String emp_First_name;
	private String emp_last_name;
//	private String address;
	private int contact_number;
	private int age;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	private Address address;
	
	public int getId() {
		return id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_First_name() {
		return emp_First_name;
	}
	public void setEmp_First_name(String emp_First_name) {
		this.emp_First_name = emp_First_name;
	}
	public String getEmp_last_name() {
		return emp_last_name;
	}
	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
	public int getContact_number() {
		return contact_number;
	}
	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
