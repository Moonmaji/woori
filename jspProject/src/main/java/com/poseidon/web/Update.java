package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;
import com.poseidon.util.Util;

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Update() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("b_no") != null) {
			if (Util.str2Int(request.getParameter("b_no"))) {
				int b_no = Integer.parseInt(request.getParameter("b_no"));
				HttpSession session = request.getSession();
				if (session.getAttribute("m_id") != null) {
					//bno있고 숫자이고 mid가 있다
					//원래 써 있던 글을 가져와야한다
					
					BoardDAO dao = new BoardDAO();
					BoardDTO dto = dao.detail(b_no);//어느 글
					//디스패쳐 이동
					RequestDispatcher rd = request.getRequestDispatcher("./update.jsp");
					request.setAttribute("dto", dto);
					rd.forward(request, response);
					
				} else {
					response.sendRedirect("./indes.jsp");//로그인해라
				}
			} else {
				response.sendRedirect("./board");//숫자가 아니다
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//b_no,b_title,b_content AND m_id
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("m_id") != null) {
			if (request.getParameter("b_no") != null && Util.str2Int(request.getParameter("b_no"))) {
				int b_no = Integer.parseInt(request.getParameter("b_no"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
//			    System.out.println(b_no);
//				System.out.println(title);
//				System.out.println(content);
				BoardDTO dto = new BoardDTO();
				dto.setB_no(b_no);
				dto.setB_title(title);
				dto.setB_content(content);
				dto.setM_id((String) session.getAttribute("m_id"));
				BoardDAO dao = new BoardDAO();
				dao.update(dto);
				
				response.sendRedirect("./detail?b_no="+b_no);
				                                     
			}else {
				response.sendRedirect("/.board");
			}
//			System.out.println(request.getParameter("b_no"));
//			System.out.println(request.getParameter("b_title"));
//			System.out.println(request.getParameter("b_content"));
		}else {
			response.sendRedirect("./index.jsp");
		}
		
	}

}
