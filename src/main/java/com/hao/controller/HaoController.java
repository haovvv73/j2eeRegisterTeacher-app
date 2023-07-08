package com.hao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hao.dao.ProfessorDao;
import com.hao.dao.ProfessorDaoImpl;
import com.hao.model.Professor;
import com.hao.model.Student;

/**
 * Servlet implementation class HaoController
 */
@WebServlet("/")
public class HaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		// get data
		// session - cart
		HttpSession session = request.getSession();
		ProfessorDao professorDao;
		
		List<Professor> ls = (ArrayList<Professor>)session.getAttribute("ls");
		
		if(ls != null) {
			professorDao = new ProfessorDaoImpl(ls);
		}else {
			professorDao = new ProfessorDaoImpl();
		}
		
		String address = "";
		
		switch (action) {
			case "/info":
				// INFO PAGE
				String txt = request.getParameter("noProfessor");
				Professor gs = professorDao.getProfessor(Integer.parseInt(txt));
				
				request.setAttribute("giaosu", gs);
				request.setAttribute("listStudent",gs.getListStudent());
				address = "form.jsp";
				break;
			case "/add":
				String noST = request.getParameter("noStudent");
				String nameST = request.getParameter("nameStudent");
				String majorST = request.getParameter("majorStudent");
				String noProfessor = request.getParameter("noProfessor");
				
				// create new student
				Student newST = new Student(Integer.parseInt(noST), nameST, majorST);
				
				// register
				boolean isRight = professorDao.registerProfessor(newST, Integer.parseInt(noProfessor));
				
				if(isRight == true) {
					// go back 
					Professor gs1 = professorDao.getProfessor(Integer.parseInt(noProfessor));
					request.setAttribute("giaosu", gs1);
					request.setAttribute("listStudent",gs1.getListStudent());
					address = "form.jsp";
				}
				
				session.setAttribute("ls", professorDao.getAllProfessor());
				break;
			case "/delete":
				String noST1 = request.getParameter("noStudent");
				String noProfessor1 = request.getParameter("noProfessor");
				int newNoST = Integer.parseInt(noST1);
				int newNoProfessor1 = Integer.parseInt(noProfessor1);
				
				// delete
				boolean isRight1 = professorDao.deleteStudent(newNoST, newNoProfessor1);
				
				if(isRight1 == true) {
					// go back 
					Professor gs1 = professorDao.getProfessor(newNoProfessor1);
					request.setAttribute("giaosu", gs1);
					request.setAttribute("listStudent",gs1.getListStudent());
					address = "form.jsp";
				}
				
				session.setAttribute("ls", professorDao.getAllProfessor());
				break;
			default:
				// HOME PAGE
				// set data
				request.setAttribute("listProfessor", professorDao.getAllProfessor());
				address = "list.jsp";
		}
		
		// go to page
        RequestDispatcher rd1 = request.getRequestDispatcher(address);  
        rd1.forward(request, response); 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
