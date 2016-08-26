package com.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection getMyOracleConnection() {
		
		Connection conn = null;
		String DB_URL = "jdbc:oracle:thin:@abhinavkaul95:1521:XE",
				USER = "system",
				PW = "sapjuly16";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PW);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
