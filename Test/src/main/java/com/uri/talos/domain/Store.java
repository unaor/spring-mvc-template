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
@Table(name = "stores",schema="talos")
public class Store implements Serializable{
	

	private static final long serialVersionUID = 3078823990842602712L;
	@Id
	@GeneratedValue(generator="auto_increment")
    @GenericGenerator(
    		name="auto_increment", strategy="increment" ,
    			    parameters = {
    		        @Parameter(name="schema", value = "talos") } 
    )
	@Column(name="store_id")
	private Integer storeId;
	@Column(name="store_nit")
	private String storeNit;
	@Column(name="store_name")
	private String storeName;
	
	public Store(){}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreNit() {
		return storeNit;
	}

	public void setStoreNit(String storeNit) {
		this.storeNit = storeNit;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}
