package com.poseidon.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dao.CommentDAO;
import com.poseidon.dto.CommentDTO;
import com.poseidon.util.Util;


@WebServlet("/commentWrite")
public class CommentWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CommentWrite() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
	
		if (session.getAttribute("m_id") != null) {
			if (request.getParameter("b_no")!=null && Util.str2Int(request.getParameter("b_no"))) {
				
				CommentDTO dto = new CommentDTO();
				BoardDAO dao = new BoardDAO();
				
				String comment = request.getParameter("comment");
				comment = comment.replaceAll("<", "&nbsp;");
				comment = comment.replaceAll(">", "&nbsp;");
				
				
				dto.setB_no(Integer.parseInt(request.getParameter("b_no")));
				dto.setC_comment(request.getParameter("comment"));
				//m_id, m_name
				dto.setM_id((String)session.getAttribute("m_id"));
				
				
				dao.commentWrite(dto);
				
				response.sendRedirect("./detail?b_no="+dto.getB_no());
			
			}else {
				//숫자가 없거나 변환이 안 됨
			}
		}else {
			//로그인 하지 않음
		}
		
//		request.setCharacterEncoding("UTF-8");
//		
//		System.out.println(request.getParameter("comment"));
//		System.out.println(Integer.parseInt(request.getParameter("b_no")));
	
	}

}
