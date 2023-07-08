package com.hao.model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private int no;
	private String name;
	private String department;
	private List<Student> listStudent;
	
	public Professor(int no, String name, String department) {
		setNo(no);
		setName(name);
		setDepartment(department);
		listStudent = new ArrayList<Student>();
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}


	public List<Student> getListStudent() {
		return listStudent;
	}
	
	public void addStudent(Student st) {
		listStudent.add(st);
	}
	
	public void deleteStudent(int noStudent) {
		for(Student student : listStudent) {
			if(student.getNo() == noStudent) listStudent.remove(student);
		}
	}
}
