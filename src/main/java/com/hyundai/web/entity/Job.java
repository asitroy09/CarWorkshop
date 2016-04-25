package com.hyundai.web.entity;

// Generated Apr 19, 2016 10:07:11 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import com.hyundai.web.jsonview.Views;


/**
 * Job generated by hbm2java
 */
public class Job implements java.io.Serializable {

	@JsonView(Views.Public.class)
	private long id;
	@JsonView(Views.Public.class)
	private Employee employee;
	@JsonView(Views.Public.class)
	private String vehRegNo;
	@JsonView(Views.Public.class)
	private Date jobDate;
	@JsonView(Views.Public.class)
	private String status;
	@JsonView(Views.Public.class)
	private Set joblines = new HashSet(0);

	public Job() {
	}

	public Job(long id) {
		this.id = id;
	}

	public Job(long id, Employee employee, String vehRegNo, Date jobDate,
			String status, Set joblines) {
		this.id = id;
		this.employee = employee;
		this.vehRegNo = vehRegNo;
		this.jobDate = jobDate;
		this.status = status;
		this.joblines = joblines;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getVehRegNo() {
		return this.vehRegNo;
	}

	public void setVehRegNo(String vehRegNo) {
		this.vehRegNo = vehRegNo;
	}

	public Date getJobDate() {
		return this.jobDate;
	}

	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getJoblines() {
		return this.joblines;
	}

	public void setJoblines(Set joblines) {
		this.joblines = joblines;
	}

}
