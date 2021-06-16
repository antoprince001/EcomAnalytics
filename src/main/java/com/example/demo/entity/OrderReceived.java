package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="OrderReceived",schema="ecom")
public class OrderReceived extends keyEntity{
	
	private int orderReceived;
	private String dateReceived;
	

	public int getOrderReceived() {
		return orderReceived;
	}
	public void setOrderReceived(int orderReceived) {
		this.orderReceived = orderReceived;
	}
	public String getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}
}

