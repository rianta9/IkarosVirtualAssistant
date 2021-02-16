package com.rianta9.ikaros.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThietLap {
	public static Connection cn;
	private String sqlInstance = "RIANTA9\\SQLEXPRESS";
	private String port = "1433";
	private String database = "IkarosSystem";
	private String nickname = "sa";
	private String password = "123456";
	
	public void connect() {
		try {
			// X�c dinh he quan tri csdl
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Xac dinh csdl thanh cong!");
			cn = DriverManager.getConnection("jdbc:sqlserver://"+sqlInstance+":"+port+";databaseName="+database+";user="+nickname+";password="+password);
			System.out.println("Ket noi csdl thanh cong!");
		}catch(Exception e) {
			System.out.println("Ket noi csdl that bai!");
			e.printStackTrace();
		}
	}
	
	public static ResultSet getTable(String tb) {
		try {
			String sql = "select * from " + tb;
			PreparedStatement s = cn.prepareStatement(sql);
			return s.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
