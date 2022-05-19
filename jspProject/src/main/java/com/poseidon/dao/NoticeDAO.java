package com.poseidon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.dto.NoticeDTO;

public class NoticeDAO extends AbstractDAO{
	
	public void noticeWrite(NoticeDTO dto) { 
		con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO may_notice (n_title, n_content, n_orifilename, n_filename, m_no) VALUES(?, ?, ?, ?,(SELECT m_no FROM may_member WHERE m_id=?))";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getN_title());
			pstmt.setString(2, dto.getN_content());
			pstmt.setString(3, dto.getN_orifilename());
			pstmt.setString(4, dto.getN_filename());
			pstmt.setString(5, dto.getM_id());
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			close(pstmt, null);
		}
	}
	
	void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if(pstmt != null) {pstmt.close();}
			if(rs != null) {rs.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<NoticeDTO> noticeList() {
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM may_noticeview";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setN_no(rs.getInt("n_no"));
				dto.setN_title(rs.getString("n_title"));
				dto.setN_content(rs.getString("n_content"));
				dto.setN_date(rs.getString("n_date"));
				dto.setN_orifilename(rs.getString("n_orifilename"));
				dto.setN_filename(rs.getString("n_filename"));
				dto.setM_no(rs.getInt("m_no"));
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				
				list.add(dto);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public NoticeDTO detail(int n_no) {
		con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM may_notice WHERE n_no=?";
		
		NoticeDTO dto = new NoticeDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, n_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setN_no(rs.getInt("n_no"));
				dto.setN_title(rs.getString("n_title"));
				dto.setN_content(rs.getString("n_content"));
				dto.setN_orifilename(rs.getString("n_orifilename"));
				dto.setN_filename(rs.getString("n_filename"));
				System.out.println(dto.getN_filename());
				dto.setN_date(rs.getString("n_date"));
				
			}
		}catch (Exception e) {
		
		}
		
		return dto;
	}

}
	


