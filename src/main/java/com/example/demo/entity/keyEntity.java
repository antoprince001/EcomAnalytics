package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class keyEntity {
	
	@Id
	@GeneratedValue
	@Column(name="PK",unique=true)
	private int pk;
	
	public int getPk() {
		return pk;
	}
	
	public void setPk(int pk) {
		this.pk = pk;
	}
}
