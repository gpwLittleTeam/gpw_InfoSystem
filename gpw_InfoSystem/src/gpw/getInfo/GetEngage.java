package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetEngage {
	public GetEngage(){
		
	}
	
	public List<Engage> getAllEngages(){
		List<Engage> result = new ArrayList<Engage>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_engage";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Engage temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("employ");
				String field3 = rs.getString("comments");
				temp = new Engage(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetEngage.java-getAllEngages() wrong!");
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
	
	public List<Engage> getEngageByCode(String code){
		List<Engage> result = new ArrayList<Engage>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_engage where code='" + code + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Engage temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("employ");
				String field3 = rs.getString("comments");
				temp = new Engage(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetEngage.java-getEngageByCode(String) wrong!");
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
	
	public List<Engage> getEngageByEmploy(String employ){
		List<Engage> result = new ArrayList<Engage>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_engage where employ = '" + employ + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Engage temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("employ");
				String field3 = rs.getString("comments");
				temp = new Engage(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetEngage.java-getEngageByEmploy(String) wrong!");
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
//		GetEngage test = new GetEngage();
//		System.out.println(test.getAllEngages());
//	}
}