package com.test.ApachePOI.entity;

import java.security.PrivateKey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	private Integer id;
	private String ename;
	private String profile;
	private Double score;
	public Employee(Integer id, String ename, String profile, Double score) {
		super();
		this.id = id;
		this.ename = ename;
		this.profile = profile;
		this.score = score;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", profile=" + profile + ", score=" + score + "]";
	}
	
}
