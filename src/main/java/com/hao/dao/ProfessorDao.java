package com.hao.dao;

import java.util.List;

import com.hao.model.Professor;
import com.hao.model.Student;

public interface ProfessorDao {
	public List<Professor> getAllProfessor();
	public List<Student> getAllStudent(int no);
	public Professor getProfessor(int no);
	public boolean registerProfessor(Student student,int noProfessor);
	public boolean deleteStudent(int noStudent,int noProfessor);
	
}
