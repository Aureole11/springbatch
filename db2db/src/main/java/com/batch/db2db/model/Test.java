package com.batch.db2db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {

	@Id
	@Column(name = "Customer_Id")
	private int customer_id;

	@Column(name = "First_Name")
	private String firstname;

	@Column(name = "Last_Name")
	private String lastname;

	@Column(name = "Age")
	private String age;

	public Test(int id, String firstname, String lastname, String age, int customer_id) {
		super();
		this.customer_id = customer_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Test [customer_id=" + customer_id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + "]";
	}
	
	
}
