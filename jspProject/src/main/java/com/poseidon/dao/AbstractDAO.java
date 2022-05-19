package com.poseidon.dao;

import java.sql.Connection;

import db.DBConnection;

class AbstractDAO {
	Connection con = null;
	
	Connection getConnection() {
		try {
			con = DBConnection.dbConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
