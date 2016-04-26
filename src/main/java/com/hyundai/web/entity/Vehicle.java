package com.hyundai.web.entity;

// Generated Apr 8, 2016 8:44:28 AM by Hibernate Tools 3.4.0.CR1

/**
 * Vehicle generated by hbm2java
 */
public class Vehicle implements java.io.Serializable {

	private String regNo;
	private String vehMake;
	private Long kmDriven;

	public Vehicle() {
	}

	public Vehicle(String regNo) {
		this.regNo = regNo;
	}

	public Vehicle(String regNo, String vehMake, Long kmDriven) {
		this.regNo = regNo;
		this.vehMake = vehMake;
		this.kmDriven = kmDriven;
	}

	public String getRegNo() {
		return this.regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getVehMake() {
		return this.vehMake;
	}

	public void setVehMake(String vehMake) {
		this.vehMake = vehMake;
	}

	public Long getKmDriven() {
		return this.kmDriven;
	}

	public void setKmDriven(Long kmDriven) {
		this.kmDriven = kmDriven;
	}

}