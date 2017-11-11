package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetSpecial {
	public GetSpecial(){
		
	}
	
	public List<Special> getAllSpecials(){
		List<Special> result = new ArrayList<Special>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_special";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Special temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("specialname");
				String field3 = rs.getString("comments");
				temp = new Special(field1, field2,field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetSpecial.java-getAllSpecials() wrong!");
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
	
	public List<Special> getSpecialByCode(String code){
		List<Special> result = new ArrayList<Special>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_special where code='" + code + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Special temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("specialname");
				String field3 = rs.getString("comments");
				temp = new Special(field1, field2,field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetSpecial.java-getSpecialByCode(String) wrong!");
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
	
	public List<Special> getSpecialBySpecialname(String specialname){
		List<Special> result = new ArrayList<Special>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_special where specialname = '" + specialname + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Special temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("specialname");
				String field3 = rs.getString("comments");
				temp = new Special(field1, field2,field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetSpecial.java-getSpecialBySpecialname(String) wrong!");
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
	
/*	public static void main(String args[]){
		GetSpecial test = new GetSpecial();
		for(int i=0;i<test.getAllSpecials().size();i++) {
			System.out.println(test.getAllSpecials().get(i).getCodeName());
		}
	}*/
}