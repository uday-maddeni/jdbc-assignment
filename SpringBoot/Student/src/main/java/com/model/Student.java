package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	

	@Id@GeneratedValue
	private int stdId;
	
	@Column(name="sname")
	private String stdName;
	private String batch;
	
	
	public Student() {
	}

	public Student(int stdId, String stdName, String batch) {
		this.stdId = stdId;
		this.stdName = stdName;
		this.batch = batch;
	}
	
	
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", batch=" + batch + "]";
	}
	
}
