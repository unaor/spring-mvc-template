package com.uri.talos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers",schema="talos")
public class Customer implements Serializable {

	private static final long serialVersionUID = 5522064539438749509L;
	
	@Id
	@Column(name="user_name")
	private String userName;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="birth_date")
	private Date birthDate;
	@Column(name="email")
	private String email;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "talos.preference_by_customer", joinColumns ={ 
	@JoinColumn(name = "user_name") }, inverseJoinColumns = {@JoinColumn(name = "preference_id") })
	private Set<Preference> preferences = new HashSet<Preference>();
	
	public Customer(){}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<Preference> preferences) {
		this.preferences = preferences;
	}	
}
