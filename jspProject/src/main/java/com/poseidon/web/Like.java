package com.poseidon.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.CommentDTO;
import com.poseidon.util.Util;

@WebServlet("/like")
public class Like extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Like() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//b_no가 오는지 검사
		//System.out.println("b_no" + request.getParameter("b_no"));
		if (request.getParameter("b_no") != null && Util.str2Int(request.getParameter("b_no"))) {
			int b_no = Integer.parseInt(request.getParameter("b_no"));
		//데이터베이스 접속 b_like +1 시키기
		BoardDAO dao = new BoardDAO();
		dao.like(b_no);//
		// ./detail?b_no=글번호로 이동시키기
		response.sendRedirect("./detail?b_no=" + b_no);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
