package com.poseidon.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.poseidon.dao.JoinDAO;

@WebServlet("/idCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IdCheck() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		//id오는지 확인
		//HttpSession session = request.getSession();
		if (request.getParameter("id") != null) {
			//System.out.println(request.getParameter("id"));
			//System.out.println("idCheck servlet");
			String id = request.getParameter("id");
			JoinDAO dao = new JoinDAO();
			int result = 1; //0 없음 1 있음
			result = dao.idCheck(id);
			//int result = dao.idCheck(id);
		
			PrintWriter pw = response.getWriter();
			pw.print(result);
			
//			if (result == 1) {
//				pw.print("이미 생성된 ID 입니다");
//			}else {
//				pw.print("생성 가능한 ID 입니다");
//			}
			
		}
		
	}

}
