package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.NoticeDAO;
import com.poseidon.dto.NoticeDTO;


@WebServlet("/noticeDetail")
public class NoticeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NoticeDetail() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		
		NoticeDAO dao = new  NoticeDAO();
		NoticeDTO noticedetail = dao.detail(n_no);
		
		RequestDispatcher rd = request.getRequestDispatcher("./noticedetail.jsp");
		request.setAttribute("noticedetail", noticedetail);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		}
	}


