package com.uri.talos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "customer_preferences",schema="talos")
public class Preference implements Serializable {


	private static final long serialVersionUID = 1052716787550296989L;
	
	@Id
	@GeneratedValue(generator="auto_increment")
    @GenericGenerator(
    		name="auto_increment", strategy="increment" ,
    			    parameters = {
    		        @Parameter(name="schema", value = "talos") } 
    )
	@Column(name="preference_id")
	private Integer preferenceId;
	@Column(name="preference_name")
	private String preferenceName;
	
	public Preference(){}

	public Integer getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(Integer preferenceId) {
		this.preferenceId = preferenceId;
	}

	public String getPreferenceName() {
		return preferenceName;
	}

	public void setPreferenceName(String preferenceName) {
		this.preferenceName = preferenceName;
	}
	
	
	
	

}
