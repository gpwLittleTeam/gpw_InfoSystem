package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetTitlegrade {
	public GetTitlegrade(){
		
	}
	
	public List<Titlegrade> getAllTitlegrades(){
		List<Titlegrade> result = new ArrayList<Titlegrade>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_titlegrade";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Titlegrade temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("titlegrade");
				String field3 = rs.getString("comments");
				temp = new Titlegrade(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetTitlegrade.java-getAllTitlegrades() wrong!");
			//ex.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Close Error!!!!!!");//
				//ex.printStackTrace();
			}
		}
	}
	
	public List<Titlegrade> getTitlegradeByCode(String code){
		List<Titlegrade> result = new ArrayList<Titlegrade>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_titlegrade where code='" + code + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Titlegrade temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("titlegrade");
				String field3 = rs.getString("comments");
				temp = new Titlegrade(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetTitlegrade.java-getTitlegradeByCode(String) wrong!");
			//ex.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Close Error!!!!!!");//
				//ex.printStackTrace();
			}
		}
	}
	
	public List<Titlegrade> getTitlegradeByTitlegrade(String titlegrade){
		List<Titlegrade> result = new ArrayList<Titlegrade>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_titlegrade where titlegrade = '" + titlegrade + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Titlegrade temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("titlegrade");
				String field3 = rs.getString("comments");
				temp = new Titlegrade(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetTitlegrade.java-getTitlegradeByTitlegrade(String) wrong!");
			//ex.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Close Error!!!!!!");//
				//ex.printStackTrace();
			}
		}
	}
	
//	public static void main(String args[]){
//		GetTitlegrade test = new GetTitlegrade();
//		System.out.println(test.getAllTitlegrades());
//	}
}