package com.hao.dao;

import java.util.ArrayList;
import java.util.List;

import com.hao.model.Professor;
import com.hao.model.Student;

public class ProfessorDaoImpl implements ProfessorDao {
	private List<Professor> data;
	
	public ProfessorDaoImpl(List<Professor> list) {
		data = list;
	}
	
	public ProfessorDaoImpl() {
		data = new ArrayList<Professor>();
		// fake data
		Professor gs1 = new Professor(1, "thao", "Math");
		Professor gs2 = new Professor(2, "david", "CNTT");
		Professor gs3 = new Professor(3, "bod", "math");
		// add data
		data.add(gs1);
		data.add(gs2);
		data.add(gs3);
	}

	@Override
	public List<Professor> getAllProfessor() {
		return data;
	}

	@Override
	public List<Student> getAllStudent(int no) {
		Professor gs = getProfessor(no);
		List<Student> danhsach = gs.getListStudent();
		
		return danhsach;
	}

	@Override
	public Professor getProfessor(int no) {
		Professor result = null;
		for(Professor gs : data) {
			if(gs.getNo() == no) {
				result = gs;
				break;
			}
		}
		
		return result;
	}

	@Override
	public boolean registerProfessor(Student student, int noProfessor) {
		Professor gs = getProfessor(noProfessor);
		List<Student> danhsach = gs.getListStudent();
		boolean isRegister = false;
		
		for(Student st : danhsach) {
			if(st.getNo() == student.getNo()) isRegister = true;
		}
		
		if(isRegister == false) {
			gs.addStudent(student);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteStudent(int noStudent, int noProfessor) {
		Professor gs = getProfessor(noProfessor);
		gs.deleteStudent(noStudent);
		return true;
	}

}
