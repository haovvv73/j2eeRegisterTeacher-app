package com.hao.model;

public class Student {
	private int no;
	private String name;
	private String major;
	
	public Student (int no, String name, String major) {
		setNo(no);
		setName(name);
		setMajor(major);
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
