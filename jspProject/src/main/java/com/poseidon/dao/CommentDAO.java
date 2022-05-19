package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.dto.CommentDTO;

public class CommentDAO {
	public List<CommentDTO> commentlist(b_no){
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM may_comment WHERE ";
				
		return list;
		
	}
}
