package com.cloud.api.commons.entity;

public class OrderEntity {

	private Long id;
	
	private String serial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public OrderEntity(Long id, String serial) {
		this.id = id;
		this.serial = serial;
	}

	public OrderEntity() {
	}
	
	
}
